/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppeneinteilung.gui;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author claus
 */

public class PanelGruppeEinstellungen extends JPanel {
    public PanelGruppeEinstellungen(int n){
        add(new JLabel("Gruppe "+n+":"));
    }
}
