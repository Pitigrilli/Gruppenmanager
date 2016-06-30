/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppeneinteilung.gui;

import javax.swing.JPanel;
import java.awt.LayoutManager;

/**
 *
 * @author lennard.zimmer
 */
public class PanelSport extends JPanel {

    // Die Objektvariablen für die Elemente auf dem JFrame:
    // Auf dem JPanel wird alles angeordnet. 
    // Die sichtbaren Elemente werden als Objektvariablen angelegt:
    private final javax.swing.JLabel JLabelNummer = new javax.swing.JLabel();
    private final javax.swing.JCheckBox JCheckBoxA;
    private final javax.swing.JCheckBox JCheckBoxB = new javax.swing.JCheckBox();
    private final javax.swing.JCheckBox JCheckBoxC = new javax.swing.JCheckBox();
    private final javax.swing.JCheckBox JCheckBoxD = new javax.swing.JCheckBox();
    private final javax.swing.JCheckBox JCheckBoxE = new javax.swing.JCheckBox();
    private final javax.swing.JCheckBox JCheckBoxF = new javax.swing.JCheckBox();
    private final javax.swing.JCheckBox JCheckBoxG = new javax.swing.JCheckBox();
    private final javax.swing.JCheckBox JCheckBoxH = new javax.swing.JCheckBox();
    private final javax.swing.JComboBox<String> JComboBoxSport;

    public PanelSport(int n) {
        this.setLayout(new java.awt.FlowLayout());
        this.add(JLabelNummer);
        JLabelNummer.setText(n+":");
        JCheckBoxA = new javax.swing.JCheckBox("a");
        this.add(JCheckBoxA);
        JCheckBoxA.setText("a");
        this.add(JCheckBoxB);
        JCheckBoxB.setText("b");
        this.add(JCheckBoxC);
        JCheckBoxC.setText("c");
        this.add(JCheckBoxD);
        JCheckBoxD.setText("d");
        this.add(JCheckBoxE);
        JCheckBoxE.setText("e");
        this.add(JCheckBoxF);
        JCheckBoxF.setText("f");
        this.add(JCheckBoxG);
        JCheckBoxG.setText("g");
        this.add(JCheckBoxH);
        JCheckBoxH.setText("h");

        String[] auswahl = {"Geschlecht wählen", "M", "W"};
        JComboBoxSport = new javax.swing.JComboBox<>(auswahl);
        this.add(JComboBoxSport);
    }

    public void setSport(String spo) {
        JComboBoxSport.getModel().setSelectedItem(spo);
    }

    public String[] getKlassen() {
        String[] klassen = new String[8];
        if (JCheckBoxA.isSelected()) {
            klassen[0] = "a";
        }
        if (JCheckBoxB.isSelected()) {
            klassen[1] = "b";
        }
        if (JCheckBoxC.isSelected()) {
            klassen[2] = "c";
        }
        if (JCheckBoxD.isSelected()) {
            klassen[3] = "d";
        }
        if (JCheckBoxE.isSelected()) {
            klassen[4] = "e";
        }
        if (JCheckBoxF.isSelected()) {
            klassen[5] = "f";
        }
        if (JCheckBoxG.isSelected()) {
            klassen[6] = "g";
        }
        if (JCheckBoxH.isSelected()) {
            klassen[7] = "h";
        }
        return klassen;
    }

    public String getSport() {
        return (String) JComboBoxSport.getModel().getSelectedItem();
    }

    public void checkKlassen(String[] args) {
        for (String s : args) {
            if (s == null) {
                continue;
            }
            switch (s) {
                case "a":
                    JCheckBoxA.setSelected(true);
                    break;
                case "b":
                    JCheckBoxB.setSelected(true);
                    break;
                case "c":
                    JCheckBoxC.setSelected(true);
                    break;
                case "d":
                    JCheckBoxD.setSelected(true);
                    break;
                case "e":
                    JCheckBoxE.setSelected(true);
                    break;
                case "f":
                    JCheckBoxF.setSelected(true);
                    break;
                case "g":
                    JCheckBoxG.setSelected(true);
                    break;
                case "h":
                    JCheckBoxH.setSelected(true);
                    break;

            }
        }
    }

}
