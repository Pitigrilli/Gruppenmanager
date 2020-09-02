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
 * @author schwindt.christian
 */
public class GruppeSport extends SortierbareGruppe implements Serializable {

    private String geschlecht;
    private String[] klassen;
    private final Jahrgang jahrgang;

    public GruppeSport( Jahrgang j, String g) {
        jahrgang = j;
        schueler = new ArrayList<>();
        geschlecht = g;
        klassen = new String[8];
    }

    public int getSportgroesse() {
        return schueler.size();
    }

    public String getGeschlecht() {
        return geschlecht;

    }

    public void klasseHinzufügen(String k) {
        int i = 0;
        while (klassen[i] != null) {
            i++;
        }
        klassen[i] = k;
    }

    public void setGeschlecht(String geschlecht) {
        this.geschlecht = geschlecht;
    }

    public String[] getKlassen() {
        return klassen;
    }

    public String getTitel() {
        titel = getGeschlecht() + " " + Arrays.toString(klassen) + ": ";
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
