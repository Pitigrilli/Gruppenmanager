/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppeneinteilung;

/**
 *
 * @author floth.rene
 */

import java.util.ArrayList;
public class Jahrgang 
{
    //Variablen--------------------------
    private ArrayList[] klassen;
    private ArrayList alle;
    private int stufe;
    private int schüleranzahl;
    private int weiblich;
    private int männlich;
    private int klassenanzahl;
    private boolean nachReligion;
    private boolean nachZweig;
    private boolean nachFremdsprache;
    
    
    
    
    //Methoden---------------------------
    
    public void setStufe(int i)
    {
        stufe = i;
    }
    
    public void setSchülerAnzahl(int i)
    {
        schüleranzahl = i;
    }
    
    public int getSchülerAnzahl()
    {
        return schüleranzahl;
    }
    public void setWeiblich(int i)
    {
        weiblich = i;
        männlich = schüleranzahl - weiblich;
    }
    
    public void setKlassenanzahl(int i)
    {
        klassenanzahl = i;
    }
    
    public void setNachReligion()
    {
        nachReligion = true;
        nachZweig = false;
        nachFremdsprache = false;
    }
    public void setNachZweig()
    {
        nachReligion = false;
        nachZweig = true;
        nachFremdsprache = false;
    }
    
    public void setNachFremdsprache()
    {
        nachReligion = false;
        nachZweig = false;
        nachFremdsprache = true;
    }
}
    

