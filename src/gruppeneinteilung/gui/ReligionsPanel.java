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
add(JCheckBox1);JCheckBox1.setName("a");
JCheckBox2.setName("b");
JCheckBox3.setName("c");
JCheckBox4.setName("d");
JCheckBox5.setName("e");
JCheckBox6.setName("f");
JCheckBox7.setName("g");
JCheckBox8.setName("h");
JComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Religion wählen", "Katholisch", "Ethik", "Evangelisch"}));


}
public static void main(String args[]) {
        // Ein Objekt der Klasse erzeugen und sichtbar machen.
        new ReligionsPanel().setVisible ( true );
    }
}

