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
 * @author lutz.laurens
 */
public class ReligionsPanel extends JPanel {

    // Die Objektvariablen für die Elemente auf dem JFrame:
    // Auf dem JPanel wird alles angeordnet. 
    // Die sichtbaren Elemente werden als Objektvariablen angelegt:
    private final javax.swing.JCheckBox JCheckBoxA;
    private final javax.swing.JCheckBox JCheckBoxB = new javax.swing.JCheckBox();
    private final javax.swing.JCheckBox JCheckBoxC = new javax.swing.JCheckBox();
    private final javax.swing.JCheckBox JCheckBoxD = new javax.swing.JCheckBox();
    private final javax.swing.JCheckBox JCheckBoxE = new javax.swing.JCheckBox();
    private final javax.swing.JCheckBox JCheckBoxF = new javax.swing.JCheckBox();
    private final javax.swing.JCheckBox JCheckBoxG = new javax.swing.JCheckBox();
    private final javax.swing.JCheckBox JCheckBoxH = new javax.swing.JCheckBox();
    private final javax.swing.JComboBox<String> JComboBoxReligion;

    public ReligionsPanel() {
        this.setLayout(new java.awt.FlowLayout());
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

        String[] auswahl = {"Religion wählen", "RK", "ETH", "EV", "ORTH"};
        JComboBoxReligion = new javax.swing.JComboBox<>(auswahl);
        this.add(JComboBoxReligion);
    }

    public void setReligion(String rel) {
        JComboBoxReligion.getModel().setSelectedItem(rel);
    }

    public String[] getKlassen() {
        String[] klassen = new String[8];
        if (JCheckBoxA.isSelected()) {
            klassen[0] = "a";
        } else if (JCheckBoxB.isSelected()) {
            klassen[1] = "b";
        } else if (JCheckBoxC.isSelected()) {
            klassen[2] = "c";
        } else if (JCheckBoxD.isSelected()) {
            klassen[3] = "d";
        } else if (JCheckBoxE.isSelected()) {
            klassen[4] = "e";
        } else if (JCheckBoxF.isSelected()) {
            klassen[5] = "f";
        } else if (JCheckBoxG.isSelected()) {
            klassen[6] = "g";
        } else if (JCheckBoxH.isSelected()) {
            klassen[7] = "h";
        }
        return klassen;
    }

    public String getReligion() {
        return (String) JComboBoxReligion.getModel().getSelectedItem();
    }

    public void checkKlassen(String[] args) {
        for (String s : args) {
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
