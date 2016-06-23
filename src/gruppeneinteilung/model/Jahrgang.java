/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppeneinteilung.model;

/**
 *
 * @author floth.rene
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Jahrgang implements Serializable {

    //Variablen--------------------------
    private final int jahrgang;
    private final ArrayList<Klasse> klassen;
    private ArrayList<Sportgruppe> sportgruppen;
    private ArrayList<Religionsgruppe> religionsgruppen;
    private ArrayList<Zweiggruppe> zweiggruppen;
    private ArrayList<Fremdsprachengruppe> fremdsprachengruppen;
    private final ArrayList<Student> alle;
    private int schuelerAnzahl;
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
    private boolean nachSprache;
    private boolean nachSport;
    private int sportgruppenzahl;
    private int religionsgruppenzahl;
    private int zweiggruppenzahl;
    private int fremdsprachengruppenzahl;

    public static void main(String[] args) {
        Gruppeneinteilung ge = new Gruppeneinteilung("ASV.csv");
        Jahrgang j = ge.getJahrgang(7);
        Klasse k = j.getKlasse("b");
        //  ge.testeEinteilung();
//        for (int i = 5; i < 11; i++) {
//            ge.getJahrgang(i).testKlassen();
//        }
        j.testKlassen();
        //System.out.println(k);
        //k.test();
        //k.sortierenName();
        //  ge.getJahrgang(5).getKlasse("b").test();
        // ge.getJahrgang(5).getKlasse("b").sortierenGeschlecht();
        //   ge.getJahrgang(5).getKlasse("b").test();

        //j.religionsgruppeErstellen("ETH");
        //j.getReligionsgruppen().get(0).klasseHinzufügen("a");
        // j.religionsgruppenZuordnen();
    }

    public Jahrgang(int n) {

        klassen = new ArrayList<>();
        sportgruppen = new ArrayList<>();
        religionsgruppen = new ArrayList<>();
        zweiggruppen = new ArrayList<>();
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

    public Klasse getKlasse(String b) {
        int n = -1;
        if (b.equals("a")) {
            n = 0;
        }
        if (b.equals("b")) {
            n = 1;
        }
        if (b.equals("c")) {
            n = 2;
        }
        if (b.equals("d")) {
            n = 3;
        }
        if (b.equals("e")) {
            n = 4;
        }
        if (b.equals("f")) {
            n = 5;
        }
        if (b.equals("g")) {
            n = 6;
        }
        if (b.equals("h")) {
            n = 7;
        }

        if (n != -1) {
            return klassen.get(n);
        } else {
            return null;
        }

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
        int i = 0;
        for (Klasse k : klassen) {
            if (k.getSchueler().size() > 0) {
                i++;
            }
        }
        klassenanzahl = i;
    }

    public void setNachReligion(boolean b) {
        nachReligion = b;
        //nachZweig = false;
        //nachFremdsprache = false;
    }

    public void setNachZweig(boolean b) {
        //nachReligion = false;
        nachZweig = b;
        //nachFremdsprache = false;
    }

    public void setNachSprache(boolean b) {
        //nachReligion = false;
        //nachZweig = false;
        nachSprache = b;
    }

    public void studentEinfuegen(Student s) {
        alle.add(s);
        schuelerAnzahl++;
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
        System.out.println("Klassenanzahl: " + klassenanzahl);
        for (Klasse k : klassen) {
            if (k.getKlassengroesse() > 0) {
                System.out.println("Klasse " + jahrgang + k.getBuchstabe() + ":");
                for (Student s : k.getSchueler()) {
                    System.out.println(s);
                }
            }
        }
    }

    public void sportgruppeErstellen(String geschlecht, int z) {
        Sportgruppe sp = new Sportgruppe(geschlecht, z);
        sportgruppenzahl++;
        sportgruppen.add(sp);
    }

    public void sportgruppeKlasseHinzufügen(int sportgruppe, String buchstabe) {
        sportgruppen.get(sportgruppe + 1).klasseHinzufügen(buchstabe);
        switch (buchstabe) {
            case "a":
                for (int i = 0; i < klassen.get(0).getKlassengroesse(); i++) {
                    if (klassen.get(0).getSchueler().get(i).getGeschlecht().equals(buchstabe)) {
                        sportgruppen.get(sportgruppe).studentHinzufuegen(klassen.get(0).getSchueler().get(i));
                    }
                }
                break;
            case "b":
                for (int i = 0; i < klassen.get(1).getKlassengroesse(); i++) {
                    if (klassen.get(1).getSchueler().get(i).getGeschlecht().equals(buchstabe)) {
                        sportgruppen.get(sportgruppe).studentHinzufuegen(klassen.get(1).getSchueler().get(i));
                    }
                }
                break;
            case "c":
                for (int i = 0; i < klassen.get(2).getKlassengroesse(); i++) {
                    if (klassen.get(2).getSchueler().get(i).getGeschlecht().equals(buchstabe)) {
                        sportgruppen.get(sportgruppe).studentHinzufuegen(klassen.get(2).getSchueler().get(i));
                    }
                }
                break;
            case "d":
                for (int i = 0; i < klassen.get(3).getKlassengroesse(); i++) {
                    if (klassen.get(3).getSchueler().get(i).getGeschlecht().equals(buchstabe)) {
                        sportgruppen.get(sportgruppe).studentHinzufuegen(klassen.get(3).getSchueler().get(i));
                    }
                }
                break;
            case "e":
                for (int i = 0; i < klassen.get(4).getKlassengroesse(); i++) {
                    if (klassen.get(4).getSchueler().get(i).getGeschlecht().equals(buchstabe)) {
                        sportgruppen.get(sportgruppe).studentHinzufuegen(klassen.get(4).getSchueler().get(i));
                    }
                }
                break;
            case "f":
                for (int i = 0; i < klassen.get(5).getKlassengroesse(); i++) {
                    if (klassen.get(5).getSchueler().get(i).getGeschlecht().equals(buchstabe)) {
                        sportgruppen.get(sportgruppe).studentHinzufuegen(klassen.get(5).getSchueler().get(i));
                    }
                }
                break;
            case "g":
                for (int i = 0; i < klassen.get(6).getKlassengroesse(); i++) {
                    if (klassen.get(6).getSchueler().get(i).getGeschlecht().equals(buchstabe)) {
                        sportgruppen.get(sportgruppe).studentHinzufuegen(klassen.get(6).getSchueler().get(i));
                    }
                }
                break;
        }
    }

    public void religionsgruppeErstellen(String religion) {
        Religionsgruppe re = new Religionsgruppe(religionsgruppenzahl, jahrgang, religion);
        religionsgruppenzahl++;
        religionsgruppen.add(re);
    }

    public void religionsgruppenKlasseHinzufügen(int religionsgruppe, String buchstabe) {

        religionsgruppen.get(religionsgruppe + 1).klasseHinzufügen(buchstabe);
        switch (buchstabe) {
            case "a":
                for (int i = 0; i < klassen.get(0).getKlassengroesse(); i++) {
                    if (klassen.get(0).getSchueler().get(i).getGeschlecht().equals(buchstabe)) {
                        religionsgruppen.get(religionsgruppe).studentHinzufuegen(klassen.get(0).getSchueler().get(i));
                    }
                }
                break;
            case "b":
                for (int i = 0; i < klassen.get(1).getKlassengroesse(); i++) {
                    if (klassen.get(1).getSchueler().get(i).getGeschlecht().equals(buchstabe)) {
                        religionsgruppen.get(religionsgruppe).studentHinzufuegen(klassen.get(1).getSchueler().get(i));
                    }
                }
                break;
            case "c":
                for (int i = 0; i < klassen.get(2).getKlassengroesse(); i++) {
                    if (klassen.get(2).getSchueler().get(i).getGeschlecht().equals(buchstabe)) {
                        religionsgruppen.get(religionsgruppe).studentHinzufuegen(klassen.get(2).getSchueler().get(i));
                    }
                }
                break;
            case "d":
                for (int i = 0; i < klassen.get(3).getKlassengroesse(); i++) {
                    if (klassen.get(3).getSchueler().get(i).getGeschlecht().equals(buchstabe)) {
                        religionsgruppen.get(religionsgruppe).studentHinzufuegen(klassen.get(3).getSchueler().get(i));
                    }
                }
                break;
            case "e":
                for (int i = 0; i < klassen.get(4).getKlassengroesse(); i++) {
                    if (klassen.get(4).getSchueler().get(i).getGeschlecht().equals(buchstabe)) {
                        religionsgruppen.get(religionsgruppe).studentHinzufuegen(klassen.get(4).getSchueler().get(i));
                    }
                }
                break;
            case "f":
                for (int i = 0; i < klassen.get(5).getKlassengroesse(); i++) {
                    if (klassen.get(5).getSchueler().get(i).getGeschlecht().equals(buchstabe)) {
                        religionsgruppen.get(religionsgruppe).studentHinzufuegen(klassen.get(5).getSchueler().get(i));
                    }
                }
                break;
            case "g":
                for (int i = 0; i < klassen.get(6).getKlassengroesse(); i++) {
                    if (klassen.get(6).getSchueler().get(i).getGeschlecht().equals(buchstabe)) {
                        religionsgruppen.get(religionsgruppe).studentHinzufuegen(klassen.get(6).getSchueler().get(i));
                    }
                }
                break;
        }
    }

    public void zweiggruppeErstellen(String zweig) {
        Zweiggruppe re = new Zweiggruppe(zweiggruppenzahl, jahrgang, zweig);
        zweiggruppenzahl++;
        zweiggruppen.add(re);
    }

    public void zweiggruppenKlasseHinzufügen(int zweiggruppe, String buchstabe) {
        zweiggruppen.get(zweiggruppe + 1).klasseHinzufügen(buchstabe);
        switch (buchstabe) {
            case "a":
                for (int i = 0; i < klassen.get(0).getKlassengroesse(); i++) {
                    if (klassen.get(0).getSchueler().get(i).getZweig().equals(buchstabe)) {
                        zweiggruppen.get(zweiggruppe).studentHinzufuegen(klassen.get(0).getSchueler().get(i));
                    }
                }
                break;
            case "b":
                for (int i = 0; i < klassen.get(1).getKlassengroesse(); i++) {
                    if (klassen.get(1).getSchueler().get(i).getZweig().equals(buchstabe)) {
                        zweiggruppen.get(zweiggruppe).studentHinzufuegen(klassen.get(1).getSchueler().get(i));
                    }
                }
                break;
            case "c":
                for (int i = 0; i < klassen.get(2).getKlassengroesse(); i++) {
                    if (klassen.get(2).getSchueler().get(i).getZweig().equals(buchstabe)) {
                        zweiggruppen.get(zweiggruppe).studentHinzufuegen(klassen.get(2).getSchueler().get(i));
                    }
                }
                break;
            case "d":
                for (int i = 0; i < klassen.get(3).getKlassengroesse(); i++) {
                    if (klassen.get(3).getSchueler().get(i).getZweig().equals(buchstabe)) {
                        zweiggruppen.get(zweiggruppe).studentHinzufuegen(klassen.get(3).getSchueler().get(i));
                    }
                }
                break;
            case "e":
                for (int i = 0; i < klassen.get(4).getKlassengroesse(); i++) {
                    if (klassen.get(4).getSchueler().get(i).getZweig().equals(buchstabe)) {
                        zweiggruppen.get(zweiggruppe).studentHinzufuegen(klassen.get(4).getSchueler().get(i));
                    }
                }
                break;
            case "f":
                for (int i = 0; i < klassen.get(5).getKlassengroesse(); i++) {
                    if (klassen.get(5).getSchueler().get(i).getZweig().equals(buchstabe)) {
                        zweiggruppen.get(zweiggruppe).studentHinzufuegen(klassen.get(5).getSchueler().get(i));
                    }
                }
                break;
            case "g":
                for (int i = 0; i < klassen.get(6).getKlassengroesse(); i++) {
                    if (klassen.get(6).getSchueler().get(i).getZweig().equals(buchstabe)) {
                        zweiggruppen.get(zweiggruppe).studentHinzufuegen(klassen.get(6).getSchueler().get(i));
                    }
                }
                break;
        }
    }

    public void fremdsprachengruppeErstellen(String fremdsprache) {
        Fremdsprachengruppe fg = new Fremdsprachengruppe(fremdsprachengruppenzahl, jahrgang, fremdsprache);
        fremdsprachengruppenzahl++;
        fremdsprachengruppen.add(fg);
    }

    public void fremdsprachengruppenKlasseHinzufügen(int fremdsprachengruppe, String buchstabe) {

        fremdsprachengruppen.get(fremdsprachengruppe + 1).klasseHinzufügen(buchstabe);
        switch (buchstabe) {
            case "a":
                for (int i = 0; i < klassen.get(0).getKlassengroesse(); i++) {
                    if (klassen.get(0).getSchueler().get(i).getZweig().equals(buchstabe)) {
                        fremdsprachengruppen.get(fremdsprachengruppe).studentHinzufuegen(klassen.get(0).getSchueler().get(i));
                    }
                }
                break;
            case "b":
                for (int i = 0; i < klassen.get(1).getKlassengroesse(); i++) {
                    if (klassen.get(1).getSchueler().get(i).getZweig().equals(buchstabe)) {
                        fremdsprachengruppen.get(fremdsprachengruppe).studentHinzufuegen(klassen.get(1).getSchueler().get(i));
                    }
                }
                break;
            case "c":
                for (int i = 0; i < klassen.get(2).getKlassengroesse(); i++) {
                    if (klassen.get(2).getSchueler().get(i).getZweig().equals(buchstabe)) {
                        fremdsprachengruppen.get(fremdsprachengruppe).studentHinzufuegen(klassen.get(2).getSchueler().get(i));
                    }
                }
                break;
            case "d":
                for (int i = 0; i < klassen.get(3).getKlassengroesse(); i++) {
                    if (klassen.get(3).getSchueler().get(i).getZweig().equals(buchstabe)) {
                        fremdsprachengruppen.get(fremdsprachengruppe).studentHinzufuegen(klassen.get(3).getSchueler().get(i));
                    }
                }
                break;
            case "e":
                for (int i = 0; i < klassen.get(4).getKlassengroesse(); i++) {
                    if (klassen.get(4).getSchueler().get(i).getZweig().equals(buchstabe)) {
                        fremdsprachengruppen.get(fremdsprachengruppe).studentHinzufuegen(klassen.get(4).getSchueler().get(i));
                    }
                }
                break;
            case "f":
                for (int i = 0; i < klassen.get(5).getKlassengroesse(); i++) {
                    if (klassen.get(5).getSchueler().get(i).getZweig().equals(buchstabe)) {
                        fremdsprachengruppen.get(fremdsprachengruppe).studentHinzufuegen(klassen.get(5).getSchueler().get(i));
                    }
                }
                break;
            case "g":
                for (int i = 0; i < klassen.get(6).getKlassengroesse(); i++) {
                    if (klassen.get(6).getSchueler().get(i).getZweig().equals(buchstabe)) {
                        fremdsprachengruppen.get(fremdsprachengruppe).studentHinzufuegen(klassen.get(6).getSchueler().get(i));
                    }
                }
                break;
        }
    }

    public ArrayList<Religionsgruppe> getReligionsgruppen() {

        return religionsgruppen;
    }

    public ArrayList<Zweiggruppe> getZweiggruppen() {

        return zweiggruppen;
    }

    public ArrayList<Sportgruppe> getSportgruppen() {

        return sportgruppen;
    }

    public ArrayList<Fremdsprachengruppe> getFremdsprachengruppen() {

        return fremdsprachengruppen;
    }

    public int getSportgruppenzahl() {
        return sportgruppen.size();
    }

    public int getReligionsgruppenzahl() {
        return religionsgruppen.size();
    }

    public int getZweiggruppenzahl() {
        return zweiggruppen.size();

    }

    public int getFremdsprachengruppenzahl() {
        return fremdsprachengruppen.size();
    }

    public boolean istNachReligion() {
        return nachReligion;
    }

    public boolean istNachZweig() {
        return nachZweig;
    }

    public boolean istNachSprache() {
        return nachSprache;
    }

    public boolean istNachSport() {
        return nachSport;
    }

    /**
     * Ordnet die Schüler den entsprechenden Religionsgruppen zu.
     */
    public void religionsgruppenZuordnen() {
        int i = 1;
        for (Religionsgruppe aktuelleRG : religionsgruppen) {
            String religion = aktuelleRG.getReligion();
            System.out.println("ReliGruppe " + i + ": " + religion);
            String[] klassenBuchstaben = aktuelleRG.getKlassen();
            System.out.println("Klassen:" + Arrays.toString(klassenBuchstaben) + "\n");

            List<String> klassenList = Arrays.asList(klassenBuchstaben);
            System.out.println("Klassen in List:" + klassenList + "\n");

            for (Klasse k : klassen) {
                if (k.getKlassengroesse() > 0) {
                    for (Student student : k.getSchueler()) {
                        if (klassenList.contains(student.getKlasse())&& student.getReligion().equals(aktuelleRG.getReligion())
                                ) {
                            aktuelleRG.studentHinzufuegen(student);
                        }
                    }
                }
            }

//            for (Student student: alle) {
//                System.out.println(student);
//                if (klassenList.contains(student.getKlasse())&& student.getReligion().equals(aktuelleRG.getReligion())
////                        student.getReligion().equals(aktuelleRG.getReligion())
////                        && (student.getKlasse().equals(aktuelleRG.getKlassen()[0])
////                        || student.getKlasse().equals(aktuelleRG.getKlassen()[1]) ||
////                        student.getKlasse().equals(aktuelleRG.getKlassen()[2]) || 
////                        student.getKlasse().equals(aktuelleRG.getKlassen()[3]) || 
////                        student.getKlasse().equals(aktuelleRG.getKlassen()[4]))
//                        ) {
//                    //if(student.getKlasse().equals("e")){
//                        
//                    //}
//                    aktuelleRG.studentHinzufuegen(student);
//                }
//            }
        }
    }
//    
//    public void religionsgruppenZuordnen2(){
//        
//        for(Klasse k: klassen){
//            for(Student s: k.getSchueler()){
//                String b = s.getKlasse();
//                String r = s.getReligion();
//                
//            }
//        }
//    }

    public void clearReligionsgruppen() {
        religionsgruppen = new ArrayList<>();
    }
}
