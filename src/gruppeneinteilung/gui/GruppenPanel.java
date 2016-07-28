package gruppeneinteilung.gui;

/**
 *
 * @author Claus Behl
 */
import gruppeneinteilung.model.Jahrgang;
import gruppeneinteilung.model.SortierbareGruppe;
import gruppeneinteilung.model.Student;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.datatransfer.Transferable;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.*;

public class GruppenPanel extends JPanel   {

    String anzeige;
    DefaultListModel<Student> dlm = new DefaultListModel<>();
    SortierbareGruppe gruppe;
    JList<Student> gruppenListe;
    Jahrgang jahrgang;
    ArrayList<Student> schueler;
    JLabel titel;

    public GruppenPanel(SortierbareGruppe gruppe) {
        this.gruppe = gruppe;
        gruppe.addBeobachter(this);
        jahrgang = gruppe.getJahrgang();
        gruppe.aktualisiereKlassen();
        this.schueler = gruppe.getSchueler();
        this.anzeige = gruppe.getTitel() + schueler.size() + " Schüler";

        setLayout(new java.awt.BorderLayout());
        
        // Titel
        titel = new JLabel(anzeige);
        add(titel, BorderLayout.NORTH);

        // Listenmodell
        for (Student student : schueler) {
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
        for (Student student : schueler) {
            dlm.addElement(student);
        }
    }

    protected void aktualisiereTitel() {
        anzeige = gruppe.getTitel() + getAnzahlSchueler() + " Schüler";
        titel.setText(anzeige);
    }
    
   public void enableDnD() {
        gruppenListe.setDragEnabled(true);
        gruppenListe.setDropMode(DropMode.INSERT);
        gruppenListe.setTransferHandler(new TransferHandler() {

            @Override
            public boolean canImport(TransferHandler.TransferSupport info) {
                
                return info.isDataFlavorSupported(TransferableStudent.studentFlavor);
            }

            @Override
            protected Transferable createTransferable(JComponent c) {
                JList list = (JList) c;
                Student student = (Student) list.getSelectedValue();
                DefaultListModel lm = (DefaultListModel) list.getModel();
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
                    schueler.remove(student);
                    jahrgang.religionsgruppenRemove(student);
                    jahrgang.sportgruppenRemove(student);
                    jahrgang.sprachengruppenRemove(student);
                    jahrgang.zweiggruppenRemove(student);
                    gruppe.aktualisiereKlassen();
                aktualisiereTitel();
                }

                
            }
            
            @Override
            public int getSourceActions(JComponent c) {
                return MOVE;
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
                    student = (Student) t.getTransferData(TransferableStudent.studentFlavor);
                } catch (Exception e) {
                    return false;
                }
                if (insert) {
                    listModel.add(index, student);
                    schueler.add(index, student);
                }
                gruppe.aktualisiereKlassen();
                aktualisiereTitel();
                return true;
            }

        });
        /*  Ende der Definition des TransferHandler  */
       
    }
    
    public int getAnzahlSchueler() {
        return gruppe.getSchueler().size();
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
            l.setText(s.getKlasse() + " " + s.getName()
                    + " " + s.getGeschlecht() + " " + s.getZweig() + " " +
                    s.getReligion() + " " + s.getFs2() + " " + s.getFs3() + " " + 
                    s.getFs4()+" "+s.getBemerkung()
//                    + '@' + Integer.toHexString(s.hashCode())
            ); //s.getKlasse()+" "+; //s.getKlasse()+" "+
            
            return l;
        }
    }

}
