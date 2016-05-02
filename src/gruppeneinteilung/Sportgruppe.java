/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppeneinteilung;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author schwindt.christian
 */
public class Sportgruppe implements Serializable{
    private final int jahrgang;
    private final String geschlecht;
    private final int zahl;
    private final ArrayList<Student> schueler;

    public Sportgruppe (int z, int j,String g) {
       zahl = z;
        jahrgang = j;
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

    public int getZahl() {
        return zahl;
    }

    public ArrayList<Student> getSchueler() {
        return schueler;
    }
    public String getGeschlecht(){
        return geschlecht;
        
    }
}
