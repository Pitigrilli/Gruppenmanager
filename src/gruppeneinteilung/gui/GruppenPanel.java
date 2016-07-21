package gruppeneinteilung.gui;

/**
 *
 * @author Claus Behl
 */
import gruppeneinteilung.model.Jahrgang;
import gruppeneinteilung.model.Klasse;
import gruppeneinteilung.model.SortierbareGruppe;
import gruppeneinteilung.model.Student;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;

public class GruppenPanel extends JPanel {

    String anzeige;
    SortierbareGruppe gruppe;
    Jahrgang jahrgang;
    ArrayList<Student> schuelerListe;
    JLabel titel;
    JList<Student> gruppenListe;
    DataFlavor studentFlavor = new DataFlavor(Student.class, Student.class.getSimpleName());
    DefaultListModel<Student> dlm = new DefaultListModel<>();

    public GruppenPanel(SortierbareGruppe gruppe) {
        this.gruppe = gruppe;
        jahrgang = gruppe.getJahrgang();
        gruppe.aktualisiereKlassen();
        this.schuelerListe = gruppe.getSchueler();
        this.anzeige = gruppe.getTitel() + schuelerListe.size() + " Schüler";

        setLayout(new java.awt.BorderLayout());
        // Titel
        titel = new JLabel(anzeige);
        add(titel, BorderLayout.NORTH);

        // Listenmodell
        for (Student student : schuelerListe) {
            dlm.addElement(student);
        }

        // JList
        gruppenListe = new JList<>(dlm);
        //gruppenListe.setFixedCellWidth(200);
        gruppenListe.setCellRenderer(new GruppenPanel.GruppenCellRenderer());

        //dnd
        enableDnD();

        // JList in Scrollbar
        JScrollPane scrollPane = new JScrollPane(gruppenListe,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        // Scrollbar ins Panel
        add(scrollPane, BorderLayout.CENTER);
    }

    public void aktualisiereListModel() {
        dlm.clear();
        for (Student student : schuelerListe) {
            dlm.addElement(student);
        }
    }

    public int getAnzahlSchueler() {
        return schuelerListe.size();
    }

    private void aktualisiereTitel() {
        anzeige = gruppe.getTitel() + schuelerListe.size() + " Schüler";
        titel.setText(anzeige);
    }

    static class GruppenCellRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            if (isSelected) {
                this.setBackground(Color.LIGHT_GRAY);
            } else {
                c.setBackground(Color.white);

            }

            Student s = (Student) value;
            switch (s.getKlasse()) {
                case "a":
                    c.setForeground(new Color(255, 0, 0));
                    break;
                case "b":
                    c.setForeground(new Color(0, 255, 0));
                    break;
                case "c":
                    c.setForeground(new Color(0, 0, 255));
                    break;
                case "d":
                    c.setForeground(new Color(0, 0, 0));
                    break;
                case "e":
                    c.setForeground(new Color(0, 255, 255));
                    break;
                case "f":
                    c.setForeground(new Color(255, 0, 255));
                    break;
                case "g":
                    c.setForeground(new Color(128, 128, 0));
                    break;
                case "h":
                    c.setForeground(new Color(255, 100, 0));
                    break;
            }
            JLabel l = (JLabel) c;
            l.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.black));
            l.setText(s.getKlasse() + " " + s.getName() + " " + s.getGeschlecht() + " " + s.getZweig() + " " + s.getReligion() + " " + s.getFs2() + " " + s.getFs3() + " " + s.getFs4()); //s.getKlasse()+" "+
            return l;
        }
    }

    public void enableDnD() {
        gruppenListe.setDragEnabled(true);
        gruppenListe.setTransferHandler(new TransferHandler() {
            //Student student;

            @Override
            public int getSourceActions(JComponent c) {
                return MOVE;
            }

            @Override
            protected Transferable createTransferable(JComponent c) {
                JList list = (JList) c;
                Student student = (Student) list.getSelectedValue();
                DefaultListModel lm = (DefaultListModel) list.getModel();
                int index = lm.indexOf(student);
                //System.out.println("Ausgewählt:"+student+" Index: "+index);

                return new TransferableStudent(student);
            }

            @Override
            protected void exportDone(JComponent c, Transferable t, int action) {
                TransferableStudent ts = (TransferableStudent) t;
                Student student = ts.getStudent();
                JList list = (JList) c;
                DefaultListModel listModel = (DefaultListModel) list.getModel();

                if (action == MOVE) {
                    listModel.removeElement(student);
                    schuelerListe.remove(student);
                }

                gruppe.aktualisiereKlassen();
                aktualisiereTitel();
            }

            @Override
            public boolean canImport(TransferHandler.TransferSupport info) {

                return info.isDataFlavorSupported(studentFlavor);
            }

            @Override
            public boolean importData(TransferHandler.TransferSupport info) {
                if (!info.isDrop()) {
                    return false;
                }

                JList list = (JList) info.getComponent();

                @SuppressWarnings("unchecked")
                DefaultListModel<Student> listModel = (DefaultListModel<Student>) list.getModel();

                JList.DropLocation dl = (JList.DropLocation) info.getDropLocation();
                int index = dl.getIndex();
                boolean insert = dl.isInsert();

                Transferable t = info.getTransferable();
                Student student;
                try {
                    student = (Student) t.getTransferData(studentFlavor);
                } catch (Exception e) {
                    return false;
                }
     // Beim Verschieben wird ein neues StudentenObjekt erzeugt, mit den gleichen Werten
                // wie das Verschobene. Damit existieren zwei Studentenobjekte mit den gleichen Werten
                // einmal in der ArrayList Jahrgang.alle und das in der Klasse durch Drop erzeugte.
                // Wir suchen das zu dem verschobenen Studentenobejekt gehörende Objekt in Jahrgang.alle 
                // und ersetzen damit das Objekt das durch den Drop-Vorgang erzeugte.
                for(Student s: jahrgang.gibAlle()){
                    if(s.istGleich(student)){
                        student = s;
                        //System.out.println("Gefunden");
                        break;
                    }
                }
                //System.out.println("Drop:"+student);
                if (insert) {
                    listModel.add(index, student);
                    schuelerListe.add(index, student);
                }
                gruppe.aktualisiereKlassen();
                aktualisiereTitel();
                return true;
            }

        });
        /*  Ende der Definition des TransferHandler  */
        gruppenListe.setDropMode(DropMode.INSERT);

    }

}
