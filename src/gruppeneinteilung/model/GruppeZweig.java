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

public class GruppeZweig extends SortierbareGruppe implements Serializable {

    private final Jahrgang jahrgang;
    private String Zweig;
    private String[] klassen;

    public GruppeZweig(Jahrgang j, String g) {
        jahrgang = j;
        schueler = new ArrayList<>();
        Zweig = g;
        klassen = new String[8];
    }

    public int getZweiggroesse() {
        return schueler.size();
    }

    public String getZweig() {
        return Zweig;

    }

    public void klasseHinzufügen(String k) {
        int i = 0;
        while (klassen[i] != null) {
            i++;
        }
        klassen[i] = k;
    }

    public void setZweig(String zweig) {
        this.Zweig = zweig;
    }

    public String[] getKlassen() {
        return klassen;
    }

    public String getTitel() {
        titel = getZweig() + " " + Arrays.toString(klassen) + ": ";
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
