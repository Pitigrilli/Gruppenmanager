package gruppeneinteilung.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author schwindt.christian
 */
public class Klasse extends SortierbareGruppe implements Serializable{

    private final Jahrgang jahrgang;

    private final String buchstabe;
    
    public Klasse(String b, Jahrgang j) {
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
    
    public Jahrgang getJahrgang() {
        return jahrgang;
    }

    
    
        public String getTitel() {
        titel = jahrgang.getJahrgang()+getBuchstabe() + ": ";
        return titel;
    }
    
    public void test()     
    {
        for(int i = 0; i< schueler.size(); i ++)
        {
            System.out.println(schueler.get(i).getName() + ", " + schueler.get(i).getGeschlecht());
        }
    }
    
    public void aktualisiereKlassen(){
       
    }
}
