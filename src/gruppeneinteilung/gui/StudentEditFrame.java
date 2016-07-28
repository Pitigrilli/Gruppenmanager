/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppeneinteilung.gui;

import gruppeneinteilung.model.Jahrgang;
import gruppeneinteilung.model.Student;

/**
 *
 * @author zimmer.lennard
 */
public class StudentEditFrame extends javax.swing.JFrame {

    Student s;
    Jahrgang jahrgang;
    GUI gui;

    /**
     * Creates new form StudentEditFrame
     */
    public StudentEditFrame(Student s, Jahrgang j, GUI g) {
        this.s = s;
        jahrgang = j;
        gui = g;
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField(15);
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldBem = new javax.swing.JTextField(15);
        jComboKlasse = new javax.swing.JComboBox();
        jComboJahrgang = new javax.swing.JComboBox();
        jComboZweig = new javax.swing.JComboBox();
        jComboReligion = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jComboFremdsprache2 = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboFremdsprache3 = new javax.swing.JComboBox();
        jComboFremdsprache4 = new javax.swing.JComboBox();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nachname,Vorname");

        jLabel2.setText("Klasse");

        jLabel3.setText("Jahrgang");

        jLabel4.setText("Zweig");

        jLabel5.setText("Religion");

        jTextFieldName.setText(s.getName());

        jButton1.setText("Speichern");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setText("Bemerkung");

        jTextFieldBem.setText(s.getBemerkung());

        jComboKlasse.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "a", "b", "c", "d", "e", "f","g","h" }));
        jComboKlasse.setSelectedItem(s.getKlasse());
        jComboKlasse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboKlasseActionPerformed(evt);
            }
        });

        jComboJahrgang.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "5", "6", "7", "8","9","10" }));
        jComboJahrgang.setSelectedItem(""+s.getJahrgang());
        jComboJahrgang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboJahrgangActionPerformed(evt);
            }
        });

        jComboZweig.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"GY", "GY_NTG_8", "GY_WSG-S_8", "GY_SG_8", "MU", "TH"}));
        jComboZweig.setSelectedItem(s.getZweig());
        jComboZweig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboZweigActionPerformed(evt);
            }
        });

        jComboReligion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "RK", "EV", "ETH", "ORTH" }));
        jComboReligion.setSelectedItem(s.getReligion());

        jLabel7.setText("Fremdsprache2");

        jComboFremdsprache2.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"", "L", "F","Sps"}));
        jComboFremdsprache2.setSelectedItem(s.getFs2());

        jLabel8.setText("Fremdsprache3");

        jLabel9.setText("Fremdsprache4");

        jComboFremdsprache3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "","Sps","F", "Sp"}));
        jComboFremdsprache3.setSelectedItem(s.getFs3());

        jComboFremdsprache4.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"", "Sps", "L", "Sp"}));
        jComboFremdsprache4.setSelectedItem(s.getFs4());
        jComboFremdsprache4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboFremdsprache4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(198, 198, 198)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jComboKlasse, 0, 211, Short.MAX_VALUE)
                            .addComponent(jComboJahrgang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboZweig, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboReligion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldName)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(220, 220, 220)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboFremdsprache2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboFremdsprache3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel6))
                        .addGap(220, 220, 220)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboFremdsprache4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldBem))))
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboKlasse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboJahrgang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboZweig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboReligion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboFremdsprache2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboFremdsprache3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboFremdsprache4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(23, 23, 23))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextFieldBem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Speichere die Einträge
        String klasseNeu = jComboKlasse.getModel().getSelectedItem().toString();
        String klasseAlt = s.getKlasse();
        s.setReligion(jComboReligion.getModel().getSelectedItem().toString());
        s.setBemerkung(jTextFieldBem.getText());
        s.setName(jTextFieldName.getText());
        s.setKlasse(jComboKlasse.getModel().getSelectedItem().toString());
        s.setJahrgang(Integer.parseInt(jComboJahrgang.getModel().getSelectedItem().toString()));
        s.setZweig(jComboZweig.getModel().getSelectedItem().toString());
        s.setFs2(jComboFremdsprache2.getModel().getSelectedItem().toString());
        s.setFs3(jComboFremdsprache3.getModel().getSelectedItem().toString());
        s.setFs4(jComboFremdsprache4.getModel().getSelectedItem().toString());

        //Klassenwechsel
        if (!klasseNeu.equals(klasseAlt)) {//Klassenwechsel
            jahrgang.getKlasse(klasseAlt).removeSchueler(s);
            jahrgang.getKlasse(klasseNeu).addSchueler(s);

            jahrgang.gruppenRemove(s);
            jahrgang.gruppenAdd(s);
//        jahrgang.religionsgruppenAdd(s);
//        jahrgang.sportgruppenAdd(s);
//        jahrgang.zweiggruppenAdd(s);
//        jahrgang.sprachengruppenAdd(s);
            gui.klassenAnzeigen();
        } else // Kein Klassenwechsel, s bleibt in der Gruppe in der er war. Die aktuellen Werte werden
        // angezeigt.
        {
            jahrgang.gruppenAktualisieren(s);
        }

        gui.allePanelsAktualisieren();

        //Schließt das Fenster
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboKlasseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboKlasseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboKlasseActionPerformed

    private void jComboZweigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboZweigActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboZweigActionPerformed

    private void jComboJahrgangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboJahrgangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboJahrgangActionPerformed

    private void jComboFremdsprache4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboFremdsprache4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboFremdsprache4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StudentEditFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentEditFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentEditFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentEditFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                // new StudentEditFrame(s).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboFremdsprache2;
    private javax.swing.JComboBox jComboFremdsprache3;
    private javax.swing.JComboBox jComboFremdsprache4;
    private javax.swing.JComboBox jComboJahrgang;
    private javax.swing.JComboBox jComboKlasse;
    private javax.swing.JComboBox jComboReligion;
    private javax.swing.JComboBox jComboZweig;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextFieldBem;
    private javax.swing.JTextField jTextFieldName;
    // End of variables declaration//GEN-END:variables
}
