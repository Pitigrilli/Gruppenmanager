package gruppeneinteilung.gui;

/**
 *
 * @author Claus Behl
 */
import gruppeneinteilung.model.Klasse;
import gruppeneinteilung.model.Student;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.datatransfer.Transferable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import static javax.swing.TransferHandler.MOVE;

public class KlassenPanel extends GruppenPanel {

    private final String buchstabe;
    private final JPopupMenu jpopupmenu;
    private final Klasse klasse;
    private final GUI parent;

    public KlassenPanel(Klasse k, GUI g) {
        super(k);
        klasse = k;
        klasse.addBeobachter(this);
        parent = g;//(GUI) SwingUtilities.getWindowAncestor(this);
        jahrgang = parent.getAktuellerJahrgang();
        buchstabe = klasse.getBuchstabe();

        setLayout(new java.awt.BorderLayout());
        
        // Titel
        titel = new JLabel();
        aktualisiereTitel();
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
                int auswahl = JOptionPane.showConfirmDialog(null, "Schüler wirklich löschen", "Warnung", 0);
                if (auswahl == JOptionPane.YES_OPTION) {
                    Student s = gruppenListe.getSelectedValue();
                    parent.ge.removeStudent(s);
                    aktualisiereListModel();
                    parent.aktualisiereLabelJahrgang();
                    parent.revalidate();
                }
            }
        });

        itemJahrgangHoch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Student student = gruppenListe.getSelectedValue();
                dlm.removeElement(student);
                schueler.remove(student);
                parent.ge.moveStudent(student, student.getJahrgang() + 1);
                aktualisiereListModel();
                aktualisiereTitel();
                parent.aktualisiereLabelJahrgang();
                parent.revalidate();
            }
        });

        itemJahrgangRunter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Student student = gruppenListe.getSelectedValue();
                dlm.removeElement(student);
                schueler.remove(student);
                parent.ge.moveStudent(student, student.getJahrgang() - 1);
                aktualisiereListModel();
                aktualisiereTitel();
                parent.aktualisiereLabelJahrgang();
                parent.revalidate();
            }
        });

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

        // JList in Scrollbar
        JScrollPane scrollPane = new JScrollPane(gruppenListe,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
         //Scrollbar ins Panel
        add(scrollPane, BorderLayout.CENTER);
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
                //int index = lm.indexOf(student);
                //System.out.println("Ausgewählt:" + student + " Index: " + index);

                return new TransferableStudent(student);
            }

            @Override
            protected void exportDone(JComponent c, Transferable t, int action) {
                TransferableStudent ts = (TransferableStudent) t;
                Student student = ts.getStudent();
                JList list = (JList) c;
                DefaultListModel listModel = (DefaultListModel) list.getModel();
//                System.out.println("ExportDone: mit "+MOVE+" ist gleich ? "+action);
//                if (action == MOVE) {
                    listModel.removeElement(student);
                    klasse.removeSchueler(student);
                    
                    jahrgang.religionsgruppenRemove(student);
                    jahrgang.sportgruppenRemove(student);
                    jahrgang.sprachengruppenRemove(student);
                    jahrgang.zweiggruppenRemove(student);
                    //System.out.println("Remove:" + student);
                    aktualisiereTitel();
                    parent.allePanelsAktualisieren();
               //}
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
                    // Der Schüler bekommt seine Klasse richtig gesetzt
                    student.setKlasse(buchstabe);
                    listModel.add(index, student);
                    
                    schueler.add(index, student);
                    aktualisiereTitel();
                    
                    //AktualisiereGruppenzugehörigkeit
                    jahrgang.religionsgruppenAdd(student);
                    jahrgang.sportgruppenAdd(student);
                    jahrgang.zweiggruppenAdd(student);
                    jahrgang.sprachengruppenAdd(student);
                }

                return true;
            }

        }); /*  Ende der Definition des TransferHandler  */

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
                    c.setForeground(new Color(255,0,0));
                    break;
                case "EV":
                    c.setForeground(new Color(0,139,0));
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
//                    + '@' + Integer.toHexString(s.hashCode())
            ); //s.getKlasse()+" "+
            return l;
        }
    }

}
