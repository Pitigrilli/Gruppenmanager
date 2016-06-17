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
public class ReligionsPanel extends JPanel{
    
    // Die Objektvariablen für die Elemente auf dem JFrame:
 
    // Auf dem JPanel wird alles angeordnet. 
    // Es ist das Element, dem das Flow-Layout zugewiesen wird
   
 
    // Die sichtbaren Elemente werden als Objektvariablen angelegt:
    private javax.swing.JCheckBox JCheckBox1 = new javax.swing.JCheckBox();
    private javax.swing.JCheckBox JCheckBox2 = new javax.swing.JCheckBox();
    private javax.swing.JCheckBox JCheckBox3 = new javax.swing.JCheckBox();
    private javax.swing.JCheckBox JCheckBox4 = new javax.swing.JCheckBox();
    private javax.swing.JCheckBox JCheckBox5 = new javax.swing.JCheckBox();
    private javax.swing.JCheckBox JCheckBox6 = new javax.swing.JCheckBox();
    private javax.swing.JCheckBox JCheckBox7 = new javax.swing.JCheckBox();
    private javax.swing.JCheckBox JCheckBox8 = new javax.swing.JCheckBox();
    private javax.swing.JComboBox JComboBox1 = new javax.swing.JComboBox();
    
public ReligionsPanel(){
    this.setLayout(new java.awt.FlowLayout());
    this.add(JCheckBox1);JCheckBox1.setText("a");
    this.add(JCheckBox2);JCheckBox2.setText("b");
    this.add(JCheckBox3);JCheckBox3.setText("c");
    this.add(JCheckBox4);JCheckBox4.setText("d");
    this.add(JCheckBox5);JCheckBox5.setText("e");
    this.add(JCheckBox6);JCheckBox6.setText("f");
    this.add(JCheckBox7);JCheckBox7.setText("g");
    this.add(JCheckBox8);JCheckBox8.setText("h");
    this.add(JComboBox1);JComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Religion wählen", "Katholisch", "Ethik", "Evangelisch"}));
    



}

}

