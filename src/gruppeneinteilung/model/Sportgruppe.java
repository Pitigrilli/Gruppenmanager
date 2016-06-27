/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppeneinteilung.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author schwindt.christian
 */
public class Sportgruppe extends SortierbareGruppe implements Serializable {
    private String geschlecht;
    private String[] klassen;
    private int zahl;
    private final int jahrgang;
    //private final ArrayList<Student> schueler;

    public Sportgruppe (int z,int j,String g) {
        zahl = z;
        jahrgang = j;
        schueler = new ArrayList<>();
        geschlecht = g;
        klassen = new String[8];
    }

    public void studentHinzufuegen(Student s) {
        schueler.add(s);
    }

    public Student studentEntfernen(Student s) {
        schueler.remove(s);
        return s;
    }

    public int getSportgroesse() {
        return schueler.size();
    }

    public ArrayList<Student> getSchueler() {
        return schueler;
    }
    public String getGeschlecht(){
        return geschlecht;
        
    }
    public void klasseHinzufügen(String k)
{
    int i = 0;
    while(klassen[i]!= null)
    {
        i ++;
    }
    klassen[i] = k;
}
    public void setGeschlecht(String geschlecht){
    this.geschlecht=geschlecht;
    }
    
    public int getZahl()
            {
                return zahl;
            }
    public String[] getKlassen()
    {
        return klassen;
    }
    public void setKlassen(String[] klassen) {
        this.klassen = klassen;
    }
}
