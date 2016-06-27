/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppeneinteilung.model;
import java.io.Serializable;
import java.util.ArrayList;



/**
 *
 * @author floth.rene
 */
public class Fremdsprachengruppe extends SortierbareGruppe implements Serializable
{
    private final int jahrgang;
    private  String fremdsprache;
    private String[] klassen;
    
    private final int zahl;
    //private  ArrayList<Student> schueler;

    public Fremdsprachengruppe (int z, int j,String r) {
        zahl=z;
        jahrgang = j;
        schueler = new ArrayList<>();
        fremdsprache = r;
        klassen = new String[8];
    }

    public void studentHinzufuegen(Student s) {
        schueler.add(s);
    }

    public Student studentEntfernen(Student s) {
        schueler.remove(s);
        return s;
    }

    public int getFremdsprachengroesse() {
        return schueler.size();
    }

    public int getZahl() {
        return zahl;
    }

    public ArrayList<Student> getSchueler() {
        return schueler;
    }
    public String getFremdsprache(){
        return fremdsprache;
}
    public void setFremdsprache(String fremdsprache){
    this.fremdsprache=fremdsprache;
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
public String[] getKlassen()
    {
        return klassen;
    }
    
}
