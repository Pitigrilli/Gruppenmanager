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
public class Religionsgruppe extends Sortierung implements Serializable {
    private final int jahrgang;
    private final String religion;
    
    private final int zahl;
    //private final ArrayList<Student> schueler;

    public Religionsgruppe (int z, int j,String r) {
        zahl=z;
        jahrgang = j;
        schueler = new ArrayList<>();
        religion = r;
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

    public ArrayList<Student> getSchueler() {
        return schueler;
    }
    public String getReligion(){
        return religion;
}
}
