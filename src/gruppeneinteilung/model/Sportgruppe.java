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
    private final String geschlecht;

    //private final ArrayList<Student> schueler;

    public Sportgruppe (String g) {
        schueler = new ArrayList<>();
        geschlecht = g;
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
}
