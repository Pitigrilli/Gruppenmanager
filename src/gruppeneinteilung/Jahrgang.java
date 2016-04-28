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

public class Jahrgang implements Serializable {

    //Variablen--------------------------
    private final int jahrgang;
    private final ArrayList<Klasse> klassen;
    private final ArrayList<Student> alle;
    private int schüleranzahl;
    private int weiblich;
    private int maennlich;
    private int katholisch;
    private int evangelisch;
    private int ethik;
    private int GY;
    private int GY_MU;
    private int GY_TH;
    private int GY_NTG;
    private int GY_WSG;
    private int GY_SG;
    private int klassenanzahl;
    private boolean nachReligion;
    private boolean nachZweig;
    private boolean nachFremdsprache;

    public static void main(String[] args) {
        Gruppeneinteilung ge = new Gruppeneinteilung("ASV.csv");
        for (int i = 5; i < 11; i++) {
            ge.getJahrgang(i).testKlassen();
        }

    }

    public Jahrgang(int n) {

        klassen = new ArrayList<>();
        jahrgang = n;
        alle = new ArrayList<>();

        String[] klassennamen = {"a", "b", "c", "d", "e", "f", "g", "h"};

        for (String s : klassennamen) {
            klassen.add(new Klasse(s, jahrgang));
        }
    }

    //Methoden---------------------------
    public int getJahrgang() {
        return jahrgang;

    }

    public int getSchuelerAnzahl() {
        return alle.size();
    }
    
    public Klasse getKlasse(String b){
        int n = 0;
        if(b.equals("b"))n=1;
        if(b.equals("c"))n=2;
        if(b.equals("d"))n=3;
        if(b.equals("e"))n=4;
        if(b.equals("f"))n=5;
        if(b.equals("g"))n=6;
        if(b.equals("h"))n=7;
        return klassen.get(n);
    }

    public ArrayList<Klasse> getKlassen() {
        return klassen;
    }

    public int getKlassenanzahl() {
        return klassenanzahl;
    }

    public void setKlassenanzahl(int i) {
        klassenanzahl = i;
    }
        public void setKlassenanzahl() {
            int i=0;
            for(Klasse k: klassen){
                if(k.getSchueler().size()>0)i++;
            }
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
        switch (s.getGeschlecht()) {
            case "M":
                maennlich++;
                break;
            case "W":
                weiblich++;
                break;
        }
        switch (s.getReligion()) {
            case "RK":
                katholisch++;
                break;
            case "EV":
                evangelisch++;
                break;
            case "ETH":
                ethik++;
                break;
        }
        switch (s.getZweig()) {
            case "GY":
                GY++;
                break;
            case "GY_MU":
                GY_MU++;
                break;
            case "GY_TH":
                GY_TH++;
                break;
            case "GY_NTG_8":
                GY_NTG++;
                break;
            case "GY_WSG-S_8":
                GY_WSG++;
                break;
            case "GY_SG_8":
                GY_SG++;
                break;
        }
        switch (s.getKlasse()) {
            case "a":
                klassen.get(0).studentHinzufuegen(s);
                break;
            case "b":
                klassen.get(1).studentHinzufuegen(s);
                break;
            case "c":
                klassen.get(2).studentHinzufuegen(s);
                break;
            case "d":
                klassen.get(3).studentHinzufuegen(s);
                break;
            case "e":
                klassen.get(4).studentHinzufuegen(s);
                break;
            case "f":
                klassen.get(5).studentHinzufuegen(s);
                break;
            case "g":
                klassen.get(6).studentHinzufuegen(s);
                break;
            case "h":
                klassen.get(7).studentHinzufuegen(s);
                break;
        }

    }

    public void ausgabeAlle() {
        for (Student student : alle) {
            System.out.println(student);
        }
    }

    public ArrayList<Student> gibAlle() {
        return alle;
    }

    public int getMaennlich() {
        return maennlich;
    }

    public int getWeiblich() {
        return weiblich;
    }

    public int getKatholisch() {
        return katholisch;
    }

    public int getEvangelisch() {
        return evangelisch;
    }

    public int getEthik() {
        return ethik;

    }

    public int getGY() {
        return GY;
    }

    public int getGY_MU() {
        return GY_MU;
    }

    public int getGY_TH() {
        return GY_TH;
    }

    public int getGY_NTG() {
        return GY_NTG;
    }

    public int getGY_WSG() {
        return GY_WSG;
    }

    public int getGY_SG() {
        return GY_SG;
    }

    public void test() {
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("Ausgabe des Jahrgangs: " + jahrgang);
        System.out.println("Schüleranzahl: " + getSchuelerAnzahl());
        System.out.println("Männlich: " + getMaennlich());
        System.out.println("Weiblich: " + getWeiblich());
        System.out.println("EV: " + getEvangelisch());
    }

    public void testKlassen() {
        for (Klasse k : klassen) {
            if (k.getKlassengroesse() > 0) {
                System.out.println("Klasse " + jahrgang + k.getBuchstabe() + ":");
                for (Student s : k.getSchueler()) {
                    System.out.println(s);
                }
            }
        }
    }

}
