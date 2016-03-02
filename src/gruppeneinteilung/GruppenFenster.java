/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppeneinteilung;

import javax.swing.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.BorderLayout;

public class GruppenFenster extends JFrame {

    String gruppenName;

    public GruppenFenster(Student[] gruppe, String name) {
        super("JListBeispiel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        JPanel panel = new JPanel();

        panel.setLayout(new java.awt.BorderLayout());

        JLabel titel = new JLabel(name);
        panel.add(titel, BorderLayout.NORTH);

        JList<Student> gruppenListe;
        gruppenListe = new JList<>(gruppe);
        gruppenListe.setFixedCellWidth(100);
        gruppenListe.setCellRenderer(new WhiteYellowCellRenderer());

        //JList wird Panel hinzugefügt
        panel.add(gruppenListe, BorderLayout.CENTER);
        
        JScrollPane scrollPane = new JScrollPane (panel, 
            ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        add(scrollPane);
        setVisible(true);

    }

    private static class WhiteYellowCellRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (index % 2 == 0) {
                c.setBackground(Color.gray);
            } else {
                c.setBackground(Color.white);
            }
            return c;
        }
    }
}
