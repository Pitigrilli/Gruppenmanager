/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppeneinteilung.gui;

//import gruppeneinteilung.model.Student;
//import gruppeneinteilung.gui.ReligionsPanel;
//import java.awt.FlowLayout;
import gruppeneinteilung.model.Jahrgang;
import gruppeneinteilung.model.GruppeZweig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author zimmer.lennard / bauer.yannik / lutz.laurens
 */
public class EinstellungFrameZweig extends javax.swing.JFrame {

    Jahrgang jahrgang;
//    Gruppeneinteilung ge;
    int anzahlGruppen;
    GUI parent;
    int n = 1;

    /**
     * Creates new form StudentEditFrame
     * @param j
     * @param parent
     */
    public EinstellungFrameZweig(Jahrgang j, JFrame parent) {
        this.parent = (GUI) parent;
        this.jahrgang = j;
        initComponents();
        anzahlGruppen = j.getZweiggruppen().size();
        jSpinner1.setValue(anzahlGruppen);

        for (GruppeZweig rg : j.getZweiggruppen()) {
            PanelZweig rp = new PanelZweig(n);
            n++;
            String zweig = rg.getZweig();
            rp.setZweig(zweig);
//            System.out.println("Religion: "+religion);
            String[] klassen = rg.getKlassen();
//            System.out.println("Anzahl Klassen: "+klassen.length);
//            int i=0;
//            for(String s: klassen){
//                System.out.println("Klasse "+i+":"+s);
//                i++;
//            }
            rp.checkKlassen(klassen);
            jPanel1.add(rp);
        }
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
        jLabelAnzahlKlassen = new javax.swing.JLabel();
        jButtonErstellen = new javax.swing.JButton();
        jSpinner1 = new javax.swing.JSpinner();
        jButtonSchließen = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

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

        jLabelAnzahlKlassen.setText("Anzahl der Gruppen");

        jButtonErstellen.setText("Erstellen");
        jButtonErstellen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonErstellenActionPerformed(evt);
            }
        });

        jSpinner1.setValue(jahrgang.getZweiggruppenzahl());
        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(0, 0, 8, 1));
        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });

        jButtonSchließen.setText("Schließen");
        jButtonSchließen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSchließenActionPerformed(evt);
            }
        });

        jPanel1.setLayout(new java.awt.GridLayout(8, 1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonSchließen, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonErstellen))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelAnzahlKlassen)
                        .addGap(216, 216, 216)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(88, 88, 88))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAnzahlKlassen)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonErstellen)
                    .addComponent(jButtonSchließen))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Alle alten Gruppen werden gelöscht, neu angelegt und die Schüler den
     * Gruppen neu zugeordnet. Das Frame wird geschlossen
     *
     * @param evt
     */
    private void jButtonErstellenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonErstellenActionPerformed
        jahrgang.clearZweiggruppen();
        //System.out.println(anzahlGruppen);
        for (int i = 0; i < anzahlGruppen; i++) {
            PanelZweig zp = (PanelZweig) jPanel1.getComponent(i);
            String zweig = zp.getZweig();
            //System.out.println(zweig);
            jahrgang.zweiggruppeErstellen(zweig);
            String[] klassen = zp.getKlassen();
            List<String> list = new ArrayList<>(Arrays.asList(klassen));
            //System.out.println(list);
            list.removeAll(Arrays.asList("", null));
            //System.out.println(list);
            klassen = Arrays.copyOf(list.toArray(), list.toArray().length, String[].class);
            
            jahrgang.getZweiggruppen().get(i).setKlassen(klassen);
        }
        //jahrgang.testKlassen();
        //System.out.println("____________________________________________________________");
        //jahrgang.ausgabeAlle();
        jahrgang.zweiggruppenZuordnen();
        parent.zweiggruppenAnzeigen();
        parent.jComboBoxJahrgangFreigeben();
        
        dispose();
    }//GEN-LAST:event_jButtonErstellenActionPerformed

    /**
     * Schließt das Fenster ohne die Änderungen zu speichern
     *
     * @param evt
     */
    private void jButtonSchließenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSchließenActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jButtonSchließenActionPerformed

    /**
     * Der in der Spinnerbox angezeigte Wert wird mit der anzahlGruppen
     * verglichen. Ist der aktWert eins größer wird ein neues Auswahl Panel
     * hinzugefügt Ist der Wert eins kleiner wird das unterste Auswahl Panel
     * entfernt.
     *
     * @param evt
     */
    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged
        int aktWert = Integer.parseInt(jSpinner1.getValue().toString());
        if (aktWert == anzahlGruppen + 1) {
            PanelZweig zweig = new PanelZweig(n);
            n++;
            jPanel1.add(zweig);
            zweig.setVisible(true);
            anzahlGruppen++;
        } else if (aktWert == anzahlGruppen - 1) {
            n--;
            jPanel1.remove(jPanel1.getComponentCount() - 1);
            anzahlGruppen--;
            jPanel1.revalidate();
            jPanel1.repaint();
        }
    }//GEN-LAST:event_jSpinner1StateChanged

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(StudentEditFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(StudentEditFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(StudentEditFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(StudentEditFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            Gruppeneinteilung ge = new Gruppeneinteilung("ASV.csv");
//            Jahrgang jahrgang = ge.getJahrgang(5);
//
//            public void run() {
//                new EinstellungFrame(jahrgang, null).setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonErstellen;
    private javax.swing.JButton jButtonSchließen;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabelAnzahlKlassen;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner jSpinner1;
    // End of variables declaration//GEN-END:variables
}
