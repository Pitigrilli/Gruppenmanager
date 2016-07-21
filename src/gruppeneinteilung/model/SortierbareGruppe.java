


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppeneinteilung.model;

import java.util.Collections;
import java.util.ArrayList;
import java.io.Serializable;

/**
 * Sortierbare Gruppe ist die Supperklasse von Klasse und den anderen Gruppen.
 *
 * @author floth.rene
 */
public abstract class SortierbareGruppe implements Serializable {

    protected ArrayList<Student> schueler;
    protected String titel;
    protected Jahrgang jahrgang;

    public static String sortierung;

    public String getTitel() {
        return titel;
    }

    public ArrayList<Student> getSchueler() {
        return schueler;
    }
    
    public Jahrgang getJahrgang(){
        return jahrgang;
    }

    public void sortierenGeschlecht() {
        sortierung = "Geschlecht";
        Collections.sort(schueler);

    }

    public void sortierenZweig() {

        sortierung = "Zweig";
        Collections.sort(schueler);

    }

    public void sortierenReligion() {

        sortierung = "Religion";
        Collections.sort(schueler);

    }

    public void sortierenFremdsprache() {

        sortierung = "Fremdsprache";
        Collections.sort(schueler);

    }

    public void sortierenName() {

        sortierung = "Alphabet";
        Collections.sort(schueler);

    }

    public void sortierenBemerkung() {

        sortierung = "Bemerkung";
        Collections.sort(schueler);

    }
    public void sortierenKlasse() {

        sortierung = "Klasse";
        Collections.sort(schueler);

    }
    
    public void addSchueler(Student s){
        schueler.add(s);
    }
    
    public void removeSchueler(Student s){
        schueler.remove(s);
    }
    public abstract void aktualisiereKlassen();
}
