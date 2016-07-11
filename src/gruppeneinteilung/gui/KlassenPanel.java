package gruppeneinteilung.gui;

/**
 *
 * @author Claus Behl
 */
import gruppeneinteilung.model.Jahrgang;
import gruppeneinteilung.model.Klasse;
import gruppeneinteilung.model.Student;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;
import static javax.swing.TransferHandler.MOVE;

public class KlassenPanel extends JPanel {

    private final Jahrgang jahrgang;
    private final Klasse klasse;
    private final String buchstabe;
    private final String name;
    private final ArrayList<Student> schueler;

    private final JLabel titel;
    private String anzeige;
    private final JList<Student> gruppenListe;

    private final JPopupMenu jpopupmenu;
    private final GUI parent;

    private final DefaultListModel<Student> dlm = new DefaultListModel<>();

    private final DataFlavor studentFlavor;

    public KlassenPanel(Klasse k, GUI g) {
        klasse = k;
        this.schueler = klasse.getSchueler();
        this.name = klasse.getTitel();
        this.jahrgang = klasse.getJahrgang();
        parent = g;//(GUI) SwingUtilities.getWindowAncestor(this);
        buchstabe = klasse.getBuchstabe();
        this.studentFlavor = new DataFlavor(Student.class, Student.class.getSimpleName());

        setLayout(new java.awt.BorderLayout());
        // Titel
        titel = new JLabel();
        setzeTitel();
        //System.out.println(anzeige);
        add(titel, BorderLayout.NORTH);

        //Popupmenu
        jpopupmenu = new JPopupMenu();
        JMenuItem itemBearbeiten = new JMenuItem("Bearbeiten");
        JMenuItem itemLoeschen = new JMenuItem("Löschen");
        JMenuItem itemJahrgangHoch = new JMenuItem("Jahrgang aufsteigen");
        JMenuItem itemJahrgangRunter = new JMenuItem("Jahrgang absteigen");
        jpopupmenu.add(itemBearbeiten);
        jpopupmenu.add(itemLoeschen);
        jpopupmenu.add(itemJahrgangHoch);
        jpopupmenu.add(itemJahrgangRunter);

        itemBearbeiten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Student s = gruppenListe.getSelectedValue();
                new StudentEditFrame(s, jahrgang, parent).setVisible(true);
                System.out.println("Popup: " + s.getName());
            }
        });

        itemLoeschen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Student s = gruppenListe.getSelectedValue();
                parent.ge.removeStudent(s);
                aktualisiereListModel();
                parent.aktualisiereLabelJahrgang();
                parent.revalidate();
            }
        });

        itemJahrgangHoch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Student s = gruppenListe.getSelectedValue();
                parent.ge.moveStudent(s, s.getJahrgang() + 1);
            }
        });

        itemJahrgangRunter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Student s = gruppenListe.getSelectedValue();
                parent.ge.moveStudent(s, s.getJahrgang() - 1);
            }
        });

        // Listenmodell
        for (Student student : schueler) {
            dlm.addElement(student);
        }

        // JList
        gruppenListe = new JList<>(dlm);
        //gruppenListe.setFixedCellWidth(200);
        gruppenListe.setCellRenderer(new KlassenPanel.KlassenCellRenderer());
        //Contextmenu
        gruppenListe.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                check(e);
            }

            public void mouseReleased(MouseEvent e) {
                check(e);
            }

            public void check(MouseEvent e) {
                if (e.isPopupTrigger()) { //if the event shows the menu
                    gruppenListe.setSelectedIndex(gruppenListe.locationToIndex(e.getPoint())); //select the itemBearbeiten
                    jpopupmenu.show(gruppenListe, e.getX(), e.getY()); //and show the menu
                }
            }
        });// ende MouseAdapter

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

    public void enableDnD() {
        gruppenListe.setDragEnabled(true);
        gruppenListe.setDropMode(DropMode.INSERT);
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
                //System.out.println("Ausgewählt:" + student + " Index: " + index);

                return new TransferableStudent(student);
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

                //System.out.println("Drop:" + student);
                if (insert) {
                    listModel.add(index, student);
                    // Der Schüler bekommt seine Klasse richtig gesetzt

                    student.setKlasse(buchstabe);
                    schueler.add(index, student);
                    setzeTitel();
                    //AktualisiereGruppenzugehörigkeit
                    jahrgang.religionsgruppenAdd(student);
                    jahrgang.SportgruppenAdd(student);
                    jahrgang.zweiggruppenAdd(student);
                    jahrgang.sprachengruppenAdd(student);
                }

                return true;
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
                    jahrgang.SportgruppenRemove(student);
                    jahrgang.sprachengruppenRemove(student);
                    jahrgang.zweiggruppenRemove(student);
                    //System.out.println("Remove:" + student);
                    setzeTitel();
                }
            }

        }); /*  Ende der Definition des TransferHandler  */

    }

    public int getAnzahlSchueler() {
        return schueler.size();
    }

    private void setzeTitel() {
        anzeige = name + schueler.size() + " Schüler";
        titel.setText(anzeige);
    }

    static class KlassenCellRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            if (isSelected) {
                this.setBackground(Color.LIGHT_GRAY);
            } else {
                c.setBackground(Color.white);

            }

            Student s = (Student) value;
            switch (s.getReligion()) {
                case "RK":
                    c.setForeground(new Color(255, 0, 0));
                    break;
                case "EV":
                    c.setForeground(new Color(0, 255, 0));
                    break;
                case "ETH":
                    c.setForeground(new Color(0, 0, 255));
                    break;
            }
            JLabel l = (JLabel) c;
            l.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.black));
            l.setText(s.getJahrgang() + " "
                    + s.getKlasse() + " "
                    + s.getName() + " "
                    + s.getGeschlecht() + " "
                    + s.getZweig() + " "
                    + s.getReligion() + " "
                    + s.getFs2() + " "
                    + s.getFs3() + " "
                    + s.getFs4() + " "
                    + s.getBemerkung()
            ); //s.getKlasse()+" "+
            return l;
        }
    }

}
