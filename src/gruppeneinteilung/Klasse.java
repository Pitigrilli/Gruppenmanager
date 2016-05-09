package gruppeneinteilung;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author schwindt.christian
 */
public class Klasse extends Sortierung implements Serializable{

    private final int jahrgang;
    private final String buchstabe;
    //private final ArrayList<Student> schueler;
    
    public static String sortierung;

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
    
    public void test()     
    {
        for(int i = 0; i< schueler.size(); i ++)
        {
            System.out.println(schueler.get(i).getName() + ", " + schueler.get(i).getGeschlecht());
        }
    }
}
