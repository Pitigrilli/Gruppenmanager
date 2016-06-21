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
    // Es ist das Element, dem das Flow-Layout zugewiesen wird
    // Die sichtbaren Elemente werden als Objektvariablen angelegt:
    private javax.swing.JCheckBox JCheckBoxA = new javax.swing.JCheckBox();
    private javax.swing.JCheckBox JCheckBoxB = new javax.swing.JCheckBox();
    private javax.swing.JCheckBox JCheckBoxC = new javax.swing.JCheckBox();
    private javax.swing.JCheckBox JCheckBoxD = new javax.swing.JCheckBox();
    private javax.swing.JCheckBox JCheckBoxE = new javax.swing.JCheckBox();
    private javax.swing.JCheckBox JCheckBoxF = new javax.swing.JCheckBox();
    private javax.swing.JCheckBox JCheckBoxG = new javax.swing.JCheckBox();
    private javax.swing.JCheckBox JCheckBoxH = new javax.swing.JCheckBox();
    private javax.swing.JComboBox JComboBoxReligion = new javax.swing.JComboBox();

    public ReligionsPanel() {
        this.setLayout(new java.awt.FlowLayout());
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
        this.add(JComboBoxReligion);
        JComboBoxReligion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Religion wählen", "KATH", "ETH", "EV", "ORTH"}));

    }

    public void setReligion(String rel) {
        JComboBoxReligion.getModel().setSelectedItem(rel);
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
