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
public class Sprachengruppe extends SortierbareGruppe implements Serializable {

    private final int jahrgang;
    private String fremdsprache;
    private String[] klassen;
    private int wievielteSprache; // die wievielte Fremdsprache ist es
    private int zahl;
    //private  ArrayList<Student> schueler; wird gerbt

    public Sprachengruppe(int z, int j, String r, int w) {
        zahl = z;
        jahrgang = j;
        schueler = new ArrayList<>();
        fremdsprache = r;
        klassen = new String[8];
        wievielteSprache = w;
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

    public String getFremdsprache() {
        return fremdsprache;
    }

    public int getWievielteSprache() {
        return wievielteSprache;
    }

    public void setFremdsprache(String fremdsprache) {
        this.fremdsprache = fremdsprache;
    }

    public void klasseHinzufügen(String k) {
        int i = 0;
        while (klassen[i] != null) {
            i++;
        }
        klassen[i] = k;
    }

    public String[] getKlassen() {
        return klassen;
    }

    public void setKlassen(String[] klassen) {
        this.klassen = klassen;
    }

}
