/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppeneinteilung;

/**
 *
 * @author floth.rene
 */
import java.io.Serializable;
import java.util.ArrayList;

public class Jahrgang implements Serializable{

    //Variablen--------------------------

    private final int jahrgang;

    private ArrayList<Student>[] klassen;
    private ArrayList<Student> alle;
    private int stufe;
    private int schüleranzahl;
    private int weiblich;
    private int männlich;
    private int klassenanzahl;
    private boolean nachReligion;
    private boolean nachZweig;
    private boolean nachFremdsprache;

    public Jahrgang(int n) {
        jahrgang = n;
        alle = new ArrayList<>();
    }

    //Methoden---------------------------
    public int getJahrgang() {
        return jahrgang;

    }
    
    
    public ArrayList<Student>[] getKlassen() {
        return klassen;
    }

    public int getKlassenanzahl() {
        return klassenanzahl;
    }

    public int getSchülerAnzahl() {
        return alle.size();
    }

    public void setKlassenanzahl(int i) {
        klassenanzahl = i;
    }

    public void setNachReligion() {
        nachReligion = true;
        nachZweig = false;
        nachFremdsprache = false;
    }

    public void setNachZweig() {
        nachReligion = false;
        nachZweig = true;
        nachFremdsprache = false;
    }

    public void setNachFremdsprache() {
        nachReligion = false;
        nachZweig = false;
        nachFremdsprache = true;
    }

    public void studentEinfuegen(Student s) {
        alle.add(s);
        /*
         HIer müssen die Attribute angepasst werden
        */
    }

    public void ausgabeAlle() {
        for (Student student : alle) {
            System.out.println(student);
        }
    }
    
    public ArrayList<Student> gibAlle(){
        return alle;
    }
}
