package gruppeneinteilung.model;

import gruppeneinteilung.gui.GruppenPanel;
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
    protected transient GruppenPanel beobachter;

    public static String sortierung;

    public String getTitel() {
        return titel;
    }

    public void addBeobachter(GruppenPanel gp) {
        this.beobachter = gp;
    }

    public void notifyBeobachter() {
        if (beobachter != null) {
            beobachter.aktualisiereListModel();
            beobachter.revalidate();
            beobachter.repaint();
        }
    }

    public ArrayList<Student> getSchueler() {
        return schueler;
    }

    public Jahrgang getJahrgang() {
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

    public void addSchueler(Student s) {
        schueler.add(s);
        notifyBeobachter();
    }

    public void removeSchueler(Student s) {
        System.out.println("Entfernt: "+s);
        schueler.remove(s);
        notifyBeobachter();
    }
    
    public void aktualisiereSchueler(Student s){
        if(schueler.contains(s)){
            notifyBeobachter();
        }
    }

    public abstract void aktualisiereKlassen();

    public void testInhalt() {
        for (Student s : schueler) {
            System.out.println(s);
        }
    }

}
