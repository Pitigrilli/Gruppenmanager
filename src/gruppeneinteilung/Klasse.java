package gruppeneinteilung;

import java.util.ArrayList;

/**
 *
 * @author schwindt.christian
 */
public class Klasse {

    private final int jahrgang;
    private final String buchstabe;
    private final ArrayList<Student> schueler;

    public Klasse(String b, int j) {
        buchstabe = b;
        jahrgang = j;
        schueler = new ArrayList<>();
    }

    public void studentHinzufuegen(Student s) {
        schueler.add(s);
    }

    public Student studentEntfernen(Student s) {
        schueler.remove(s);
        return s;
    }

    public int getKlassengroesse() {
        return schueler.size();
    }

    public String getBuchstabe() {
        return buchstabe;
    }

    public ArrayList<Student> getSchueler() {
        return schueler;
    }

}
