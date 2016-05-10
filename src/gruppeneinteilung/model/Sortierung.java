/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppeneinteilung.model;
import java.util.Collections;
import java.util.ArrayList;
import java.io.Serializable;
/**
 *
 * @author floth.rene
 */
public class Sortierung implements Serializable
{
    protected ArrayList <Student> schueler;
    
    public void sortierenGeschlecht()
    {
        

        Klasse.sortierung = "Geschlecht";
        Collections.sort(schueler);
        
    }
    
    public void sortierenZweig()
    {

        Klasse.sortierung = "Zweig";
        Collections.sort(schueler);
        
    }
    public void sortierenReligion()
    {

        Klasse.sortierung = "Religion";
        Collections.sort(schueler);
        
    }
    
    public void sortierenFremdsprache()
    {

        Klasse.sortierung = "Fremdsprache";
        Collections.sort(schueler);
        
    }
    
    public void sortierenName()
    {

        Klasse.sortierung = "Alphabet";
        Collections.sort(schueler);
        
    }
}
