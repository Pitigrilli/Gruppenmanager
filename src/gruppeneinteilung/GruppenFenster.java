package gruppeneinteilung;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.*;
public class GruppenFenster extends JFrame {
    ArrayList<Student> students;
   

    public GruppenFenster(ArrayList<Student> students, String name) {
        super("Gruppeneinteilung");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new java.awt.BorderLayout());
        
        this.students = students;
        
        ArrayList<Student> gruppe1 = new ArrayList<> ();
        ArrayList<Student> gruppe2 = new ArrayList<> ();
        
        for (int i = 0;i<20;i++)
            gruppe1.add(students.get(i));
        for (int i = 20;i<40;i++)
            gruppe2.add(students.get(i));
        
        JPanel panel1 = new GruppenPanel(gruppe1,"Gruppe 1");
        add(panel1, BorderLayout.WEST);
        JPanel panel2 = new GruppenPanel(gruppe2,"Gruppe 2");
        add(panel2, BorderLayout.EAST);
        
        
        setVisible(true);

    }

    
}
