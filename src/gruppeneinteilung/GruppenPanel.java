package gruppeneinteilung;

/**
 *
 * @author Claus Behl
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;

public class GruppenPanel extends JPanel {

    String gruppenName;
    ArrayList<Student> gruppe;
    JList<Student> gruppenListe;
    DataFlavor studentFlavor = new DataFlavor(Student.class, Student.class.getSimpleName());
    DefaultListModel<Student> dlm = new DefaultListModel<>();

    public GruppenPanel(ArrayList<Student> gruppe, String name) {
        this.gruppe = gruppe;
        this.gruppenName = name;

        setLayout(new java.awt.BorderLayout());
        // Titel
        JLabel titel = new JLabel(name);
        add(titel, BorderLayout.NORTH);

        // Listenmodell
        for (Student student : gruppe) {
            dlm.addElement(student);
        }
        // JList
        gruppenListe = new JList<>(dlm);
        //gruppenListe.setFixedCellWidth(200);
        gruppenListe.setCellRenderer(new GruppenPanel.WhiteGrayCellRenderer());

        //dnd
        enableDnD();

        // JList in Scrollbar
        JScrollPane scrollPane = new JScrollPane(gruppenListe,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        // Scrollbar ins Panel
        add(scrollPane, BorderLayout.CENTER);
    }

    private static class WhiteGrayCellRenderer extends DefaultListCellRenderer {

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
                    c.setForeground(new Color(0,255,0));
                    break;
                case "ETH":
                    c.setForeground(new Color(0,0,255));
                    break;
            }
            JLabel l = (JLabel) c;
            l.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.black));
            return l;
        }
    }

    public void enableDnD() {
        gruppenListe.setDragEnabled(true);
        gruppenListe.setTransferHandler(
                new TransferHandler() {
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
                            gruppe.remove(student);
                        }
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

                    //System.out.println("Drop:"+student);
                        if (insert) {
                            listModel.add(index, student);
                            gruppe.add(index, student);
                        }

                        return true;
                    }

                });
        /*  Ende der Definition des TransferHandler  */
        gruppenListe.setDropMode(DropMode.INSERT);

    }

    class TransferableStudent implements Transferable {
        /*objecto to transfer with dnd*/

        Student student;

        TransferableStudent(Student student) {
            this.student = student;
        }

        Student getStudent() {
            return student;
        }

        @Override
        public DataFlavor[] getTransferDataFlavors() {
            return new DataFlavor[]{studentFlavor};
        }

        @Override
        public boolean isDataFlavorSupported(DataFlavor flavor) {
            return flavor.equals(studentFlavor);
        }

        @Override
        public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {

            if (flavor.equals(studentFlavor)) {
                return student;
            } else {
                throw new UnsupportedFlavorException(flavor);
            }
        }
    }

}
