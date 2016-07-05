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
public class GruppeReligion extends SortierbareGruppe implements Serializable {

    private final int jahrgang;
    private String religion;
    /**
     * Liste der Buchstaben der zugehörigen Klassen
     */
    private String[] klassen;
    /**
     * Nummer der GruppeReligion im Jahrgang
     */
    private final int zahl;
    //private  ArrayList<Student> schueler;

    public GruppeReligion(int z, int j, String r) {
        zahl = z;
        jahrgang = j;
        schueler = new ArrayList<>();
        religion = r;
        klassen = new String[8];
    }

    public void studentHinzufuegen(Student s) {
        schueler.add(s);
    }

    public Student studentEntfernen(Student s) {
        schueler.remove(s);
        return s;
    }

    public int getReligiongroesse() {
        return schueler.size();
    }

    public int getZahl() {
        return zahl;
    }

    public void setKlassen(String[] klassen) {
        this.klassen = klassen;
    }

    public ArrayList<Student> getSchueler() {
        return schueler;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String r) {
        religion = r;
    }

    public String[] getKlassen() {
        return klassen;
    }

    public void klasseHinzufügen(String k) {
        int i = 0;
        while (klassen[i] != null) {
            i++;
        }
        klassen[i] = k;
    }

    public String getTitel() {
        titel = getReligion() + " " + Arrays.toString(klassen) + ": ";
        return titel;
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
