/**
 *
 * @author heske.timjonathan
 */
package gruppeneinteilung;

import java.awt.Desktop;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.SpinnerNumberModel;

public class GUI extends javax.swing.JFrame {

    private Gruppeneinteilung ge;
    private Jahrgang aktuellerJahrgang;
    private File file;

    /**
     * Creates new form GUI
     */
    public GUI() {

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

        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jComboBoxJahrgang = new javax.swing.JComboBox();
        jSpinnerAnzahlKlassen = new javax.swing.JSpinner(new SpinnerNumberModel(4,1,10,1));
        jLabelKlassen = new javax.swing.JLabel();
        jComboBoxSortierung = new javax.swing.JComboBox<String>();
        jButtonAktualisieren = new javax.swing.JButton();
        jLabelSchülergesamt = new javax.swing.JLabel();
        jLabelKatholisch = new javax.swing.JLabel();
        jLabelEthik = new javax.swing.JLabel();
        jLabelEvangelisch = new javax.swing.JLabel();
        jLabelSchülergesamtAnzahl = new javax.swing.JLabel();
        jLabelKatholischAnzahl = new javax.swing.JLabel();
        jLabelEthikAnzahl = new javax.swing.JLabel();
        jLabelEvangelischAnzahl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabelMännlichAnzahl = new javax.swing.JLabel();
        jLabelMännlich = new javax.swing.JLabel();
        jLabelWeiblichAnzahl = new javax.swing.JLabel();
        jLabelWeiblich = new javax.swing.JLabel();
        jLabel1Anzahl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel2Anzahl = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel3Anzahl = new javax.swing.JLabel();
        jLabelGY_SG = new javax.swing.JLabel();
        jLabelGY_NTGAnzahl = new javax.swing.JLabel();
        jLabelGY_NTG = new javax.swing.JLabel();
        jLabelGY_WSGAnzahl = new javax.swing.JLabel();
        jLabelGY_WSG = new javax.swing.JLabel();
        jLabelGY_SGAnzahl = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelKlassen = new javax.swing.JPanel();
        jPanelSport = new javax.swing.JPanel();
        jPanelReligion = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemImport = new javax.swing.JMenuItem();
        jMenuItemOpen = new javax.swing.JMenuItem();
        jMenuItemSave = new javax.swing.JMenuItem();
        jMenuItemSaveAs = new javax.swing.JMenuItem();
        jMenuItemSettings = new javax.swing.JMenuItem();
        jMenuItemPrint = new javax.swing.JMenuItem();
        jMenuItemClose = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kursmanager");
        setPreferredSize(new java.awt.Dimension(1280, 720));

        jComboBoxJahrgang.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "5", "6", "7", "8", "9", "10"}));
        jComboBoxJahrgang.setEnabled(false);
        jComboBoxJahrgang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxJahrgangActionPerformed(evt);
            }
        });

        jSpinnerAnzahlKlassen.setEnabled(false);

        jLabelKlassen.setText("Anzahl Klassen:");

        jComboBoxSortierung.setEnabled(false);
        jComboBoxSortierung.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sortierung wählen", "Alphabetisch", "Männlich/Weiblich", "Religion", "Zweig" }));
        jComboBoxSortierung.setName(""); // NOI18N
        jComboBoxSortierung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSortierungActionPerformed(evt);
            }
        });

        jButtonAktualisieren.setText("Aktualisieren");
        jButtonAktualisieren.setEnabled(false);
        jButtonAktualisieren.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAktualisierenActionPerformed(evt);
            }
        });

        jLabelSchülergesamt.setText("Anzahl Schüler gesamt:");

        jLabelKatholisch.setText("Anzahl Katholisch:");

        jLabelEthik.setText("Anzahl Ethik:");

        jLabelEvangelisch.setText("Anzahl Evangelisch:");

        jLabelSchülergesamtAnzahl.setText("");

        jLabelKatholischAnzahl.setText("");

        jLabelEthikAnzahl.setText("");

        jLabelEvangelischAnzahl.setText("");

        jLabel1.setText("");

        jLabelMännlichAnzahl.setText("");

        jLabelMännlich.setText("Anzahl Männlich:");

        jLabelWeiblichAnzahl.setText("");

        jLabelWeiblich.setText("Anzahl Weiblich:");

        jLabel1Anzahl.setText("");

        jLabel2.setText("");

        jLabel2Anzahl.setText("");

        jLabel3.setText("");

        jLabel3Anzahl.setText("");

        jLabelGY_SG.setText("Anzahl im SG-Zweig:");

        jLabelGY_NTGAnzahl.setText("");

        jLabelGY_NTG.setText("Anzahl im NTG-Zweig:");

        jLabelGY_WSGAnzahl.setText("");

        jLabelGY_WSG.setText("Anzahl im WSG-Zweig:");

        jLabelGY_SGAnzahl.setText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelSchülergesamt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxSortierung, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxJahrgang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonAktualisieren, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelKlassen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinnerAnzahlKlassen, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelKatholisch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelEthik, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelEvangelisch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelSchülergesamtAnzahl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelKatholischAnzahl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelEthikAnzahl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelEvangelischAnzahl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelMännlichAnzahl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelWeiblichAnzahl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelMännlich, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelWeiblich, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1Anzahl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2Anzahl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3Anzahl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelGY_SG, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelGY_NTGAnzahl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelGY_NTG, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelGY_WSGAnzahl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelGY_SGAnzahl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelGY_WSG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxJahrgang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelKlassen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSpinnerAnzahlKlassen))
                .addGap(18, 18, 18)
                .addComponent(jComboBoxSortierung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonAktualisieren)
                .addGap(18, 18, 18)
                .addComponent(jLabelSchülergesamt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabelSchülergesamtAnzahl)
                .addGap(18, 18, 18)
                .addComponent(jLabelKatholisch, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabelKatholischAnzahl)
                .addGap(18, 18, 18)
                .addComponent(jLabelEthik, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabelEthikAnzahl)
                .addGap(18, 18, 18)
                .addComponent(jLabelEvangelisch, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelEvangelischAnzahl)
                .addGap(18, 18, 18)
                .addComponent(jLabelMännlich, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelMännlichAnzahl)
                .addGap(18, 18, 18)
                .addComponent(jLabelWeiblich, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelWeiblichAnzahl)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1Anzahl)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2Anzahl)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3Anzahl)
                .addGap(13, 13, 13)
                .addComponent(jLabelGY_NTG, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelGY_NTGAnzahl)
                .addGap(13, 13, 13)
                .addComponent(jLabelGY_WSG, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelGY_WSGAnzahl)
                .addGap(18, 18, 18)
                .addComponent(jLabelGY_SG, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelGY_SGAnzahl)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jComboBoxSortierung.getAccessibleContext().setAccessibleName("");

        jPanelKlassen.setLayout(new java.awt.GridLayout(1, 8));
        jTabbedPane1.addTab("Allgemein", jPanelKlassen);

        jPanelSport.setLayout(new java.awt.GridLayout(1, 8));
        jTabbedPane1.addTab("Sportgruppen", jPanelSport);

        jPanelReligion.setLayout(new java.awt.GridLayout(1, 8));
        jTabbedPane1.addTab("Religionsgruppen", jPanelReligion);

        jMenu1.setText("File");

        jMenuItemImport.setText("Import");
        jMenuItemImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemImportActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemImport);

        jMenuItemOpen.setText("Open");
        jMenuItemOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemOpenActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemOpen);

        jMenuItemSave.setText("Save");
        jMenuItemSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSaveActionPerformed(evt);
            }
        });
        jMenuItemSave.setEnabled(false);
        jMenu1.add(jMenuItemSave);

        jMenuItemSaveAs.setText("Save As");
        jMenuItemSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSaveAsActionPerformed(evt);
            }
        });
        jMenuItemSaveAs.setEnabled(false);
        jMenu1.add(jMenuItemSaveAs);

        jMenuItemSettings.setText("Settings");
        jMenuItemSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSettingsActionPerformed(evt);
            }
        });
        jMenuItemSettings.setEnabled(false);
        jMenu1.add(jMenuItemSettings);

        jMenuItemPrint.setText("Print");
        jMenuItemPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPrintActionPerformed(evt);
            }
        });
        jMenuItemPrint.setEnabled(false);
        jMenu1.add(jMenuItemPrint);

        jMenuItemClose.setText("Close");
        jMenuItemClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCloseActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemClose);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem2.setText("jMenuItem2");
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("jMenuItem3");
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("");

        getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxJahrgangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxJahrgangActionPerformed
        // TODO add your handling code here:
        evalueteJahrgangsAuswahl();
        
        int n = Integer.parseInt(jComboBoxJahrgang.getSelectedItem().toString());
        if(n==5 || n==6){
        String anzahlGY = aktuellerJahrgang.getGY()+"";
        jLabel1Anzahl.setText(anzahlGY);
        jLabel1.setText("Schüler ohne Zweig");
        String anzahlGY_MU = aktuellerJahrgang.getGY_MU()+"";
        jLabel2Anzahl.setText(anzahlGY_MU);
        jLabel2.setText("Schüler Musikklassen");
        String anzahlGY_TH = aktuellerJahrgang.getGY_TH()+"";
        jLabel3Anzahl.setText(anzahlGY_TH);
        jLabel3.setText("Schüler Theaterklassen");
    }else if(n==7){
        String anzahlGY = aktuellerJahrgang.getGY()+"";
        jLabel1Anzahl.setText(anzahlGY);
        jLabel1.setText("Schüler ohne Zweig");
    }else if(n==8 || n==9 || n==10){
        String anzahlGY_NTG = aktuellerJahrgang.getGY_NTG()+"";
        jLabel1Anzahl.setText(anzahlGY_NTG);
        jLabel1.setText("Schüler im NTG-Zweig");
        String anzahlGY_WSG = aktuellerJahrgang.getGY_WSG()+"";
        jLabel2Anzahl.setText(anzahlGY_WSG);
        jLabel2.setText("Schüler im WSG-Zweig");
        String anzahlGY_SG = aktuellerJahrgang.getGY_SG()+"";
        jLabel3Anzahl.setText(anzahlGY_SG);
        jLabel3.setText("Schüler im SG-Zweig");
    }
        String anzahlSchueler = aktuellerJahrgang.getSchuelerAnzahl()+"";
        jLabelSchülergesamtAnzahl.setText(anzahlSchueler);
        String anzahlKatholisch = aktuellerJahrgang.getKatholisch()+"";
        jLabelKatholischAnzahl.setText(anzahlKatholisch);
        String anzahlEthik = aktuellerJahrgang.getEthik()+"";
        jLabelEthikAnzahl.setText(anzahlEthik);
        String anzahlEvangelisch = aktuellerJahrgang.getEvangelisch()+"";
        jLabelEvangelischAnzahl.setText(anzahlEvangelisch);
        String anzahlMännlich = aktuellerJahrgang.getMaennlich()+"";
        jLabelMännlichAnzahl.setText(anzahlMännlich);
        String anzahlWeiblich = aktuellerJahrgang.getWeiblich()+"";
        jLabelWeiblichAnzahl.setText(anzahlWeiblich);
        
        
        jComboBoxSortierung.setEnabled(true);
    }//GEN-LAST:event_jComboBoxJahrgangActionPerformed

    private void jMenuItemOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemOpenActionPerformed
        Speicherung sp = new Speicherung();
        sp.testeLaden();
        ge = sp.serialisierungLaden();
        ge.testeEinteilung();
        this.setTitle("Kursmanager - " + ge.getFile().toString());
        evalueteJahrgangsAuswahl();
        jMenuItemSave.setEnabled(true);
        jMenuItemSaveAs.setEnabled(true);
        jMenuItemPrint.setEnabled(true);
        jComboBoxJahrgang.setEnabled(true);
        jButtonAktualisieren.setEnabled(true);
        jSpinnerAnzahlKlassen.setEnabled(true);
    }//GEN-LAST:event_jMenuItemOpenActionPerformed

    private void jMenuItemSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSettingsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemSettingsActionPerformed

    private void jMenuItemImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemImportActionPerformed
        // TODO add your handling code here:
        ge = new Gruppeneinteilung();
        ge.asvImport();
        jMenuItemSave.setEnabled(true);
        jMenuItemSaveAs.setEnabled(true);
        jMenuItemPrint.setEnabled(true);
        jComboBoxJahrgang.setEnabled(true);
        jButtonAktualisieren.setEnabled(true);
        jSpinnerAnzahlKlassen.setEnabled(true);
    }//GEN-LAST:event_jMenuItemImportActionPerformed

    private void jMenuItemCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCloseActionPerformed
        // TODO add your handling code here:
        dispose();
        System.exit(0);
    }//GEN-LAST:event_jMenuItemCloseActionPerformed

    private void jMenuItemSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSaveActionPerformed
        // TODO add your handling code here:
        new Speicherung(ge).speichern();
    }//GEN-LAST:event_jMenuItemSaveActionPerformed

    private void jComboBoxSortierungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSortierungActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxSortierungActionPerformed

    private void jButtonAktualisierenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAktualisierenActionPerformed
        // TODO add your handling code here:
        ge.testeEinteilung();
    }//GEN-LAST:event_jButtonAktualisierenActionPerformed

    private void jMenuItemSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSaveAsActionPerformed
        // TODO add your handling code here:
        new Speicherung(ge).speichernUnter();
        this.setTitle("Kursmanager - " + ge.getFile().toString());
    }//GEN-LAST:event_jMenuItemSaveAsActionPerformed

    private void jMenuItemPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPrintActionPerformed
        // TODO add your handling code here:
        PrintPDF printPdf = new PrintPDF(ge);
        File fileAusdruck = printPdf.getFile();

        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().open(fileAusdruck);
            } catch (IOException ex) {
                // no application registered for PDFs
                System.out.println("Es ist kein PDF Reader installiert.");
            }
        }

    }//GEN-LAST:event_jMenuItemPrintActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAktualisieren;
    private javax.swing.JComboBox jComboBoxJahrgang;
    private javax.swing.JComboBox<String> jComboBoxSortierung;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel1Anzahl;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel2Anzahl;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel3Anzahl;
    private javax.swing.JLabel jLabelEthik;
    private javax.swing.JLabel jLabelEthikAnzahl;
    private javax.swing.JLabel jLabelEvangelisch;
    private javax.swing.JLabel jLabelEvangelischAnzahl;
    private javax.swing.JLabel jLabelGY_NTG;
    private javax.swing.JLabel jLabelGY_NTGAnzahl;
    private javax.swing.JLabel jLabelGY_SG;
    private javax.swing.JLabel jLabelGY_SGAnzahl;
    private javax.swing.JLabel jLabelGY_WSG;
    private javax.swing.JLabel jLabelGY_WSGAnzahl;
    private javax.swing.JLabel jLabelKatholisch;
    private javax.swing.JLabel jLabelKatholischAnzahl;
    private javax.swing.JLabel jLabelKlassen;
    private javax.swing.JLabel jLabelMännlich;
    private javax.swing.JLabel jLabelMännlichAnzahl;
    private javax.swing.JLabel jLabelSchülergesamt;
    private javax.swing.JLabel jLabelSchülergesamtAnzahl;
    private javax.swing.JLabel jLabelWeiblich;
    private javax.swing.JLabel jLabelWeiblichAnzahl;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItemClose;
    private javax.swing.JMenuItem jMenuItemImport;
    private javax.swing.JMenuItem jMenuItemOpen;
    private javax.swing.JMenuItem jMenuItemPrint;
    private javax.swing.JMenuItem jMenuItemSave;
    private javax.swing.JMenuItem jMenuItemSaveAs;
    private javax.swing.JMenuItem jMenuItemSettings;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelKlassen;
    private javax.swing.JPanel jPanelReligion;
    private javax.swing.JPanel jPanelSport;
    private javax.swing.JSpinner jSpinnerAnzahlKlassen;
    private javax.swing.SpinnerModel modelKlassenAnzahl = new javax.swing.SpinnerNumberModel(0, 0, 10, 1);
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables

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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    public void evalueteJahrgangsAuswahl() {
        int n = Integer.parseInt(jComboBoxJahrgang.getSelectedItem().toString());
        aktuellerJahrgang = ge.getJahrgang(n);
        aktuellerJahrgang.setKlassenanzahl();

        //System.out.println("Jahrgang: " + aktuellerJahrgang.getJahrgang());
        int klassenanzahl = aktuellerJahrgang.getKlassenanzahl();
        //System.out.println(klassenanzahl);
        jSpinnerAnzahlKlassen.getModel().setValue(klassenanzahl);

        jPanelKlassen.removeAll();
        for (Klasse k : aktuellerJahrgang.getKlassen()) {
            if (k.getKlassengroesse() > 0) {
                jPanelKlassen.add(new GruppenPanel(k.getSchueler(), n + k.getBuchstabe()));
            }
        }
        jPanelKlassen.revalidate();
        jPanelKlassen.repaint();
        
        //Sportgruppen
    //    jPanelSport.removeAll();
    //    for (Klasse s : aktuellerJahrgang.getSportgruppen()) {
    //        if (s.getSportgruppenzahl() > 0) {
    //            jPanelSport.add(new GruppenPanel(s.getSchueler(), n + s.getBuchstabe()));
    //        }
    //    }
    //    jPanelSport.revalidate();
    //    jPanelSport.repaint();
         //Religionsgruppen 
    //    jPanelReligion.removeAll();
    //    for (Klasse r : aktuellerJahrgang.getReligionsgruppen()) {
    //        if (r.getReligionsgruppenzahl() > 0) {
    //            jPanelSport.add(new GruppenPanel(r.getSchueler(), n + r.getBuchstabe()));
    //        }
    //    }
    //    jPanelSport.revalidate();
    //    jPanelSport.repaint();
    }

}
