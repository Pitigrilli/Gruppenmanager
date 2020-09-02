/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppeneinteilung.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author floth.rene
 */
public class GruppeSprache extends SortierbareGruppe implements Serializable {

    private final Jahrgang jahrgang;
    private String fremdsprache;
    private String[] klassen;
    private int wievielteSprache; // die wievielte Fremdsprache ist es

    //private  ArrayList<Student> schueler; wird gerbt

    public GruppeSprache(Jahrgang j, String r, int w) {
        jahrgang = j;
        schueler = new ArrayList<>();
        fremdsprache = r;
        klassen = new String[8];
        wievielteSprache = w;
    }

    public int getFremdsprachengroesse() {
        return schueler.size();
    }

    public String getSprache() {
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

    public String getTitel() {
        titel = getSprache() + " " + Arrays.toString(klassen) + ": ";
        return titel;
    }

    public void setKlassen(String[] klassen) {
        this.klassen = klassen;
    }

    public void aktualisiereKlassen() {
        klassen = new String[8];
        ArrayList<String> klassenList = new ArrayList<>();
        for (Student s : schueler) {
            if (!klassenList.contains(s.getKlasse())) {
                klassenList.add(s.getKlasse());
            }
        }
        klassen = klassenList.toArray(new String[0]);
        Arrays.sort(klassen);
    }

    public boolean contains(String k) {
        List<String> list = Arrays.asList(klassen);
        return list.contains(k);
    }
}
