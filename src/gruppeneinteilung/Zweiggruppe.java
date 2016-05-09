/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppeneinteilung;
import java.io.Serializable;
import java.util.ArrayList;

public class Zweiggruppe extends Sortierung implements Serializable{
    private final int jahrgang;
    private final String Zweig;
    private final int zahl;
    //private final ArrayList<Student> schueler;

    public Zweiggruppe (int z, int j,String g) {
       zahl = z;
        jahrgang = j;
        schueler = new ArrayList<>();
        Zweig = g;
    }

    public void studentHinzufuegen(Student s) {
        schueler.add(s);
    }

    public Student studentEntfernen(Student s) {
        schueler.remove(s);
        return s;
    }

    public int getZweiggroesse() {
        return schueler.size();
    }

    public int getZahl() {
        return zahl;
    }

    public ArrayList<Student> getSchueler() {
        return schueler;
    }
    public String getZweig(){
        return Zweig;
        
    }


    
}
