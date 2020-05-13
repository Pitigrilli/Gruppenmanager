/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppenmanager.model;

/**
 *
 * @author floth.rene
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Jahrgang implements Serializable {

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
    private int GY;
    private int GY_NTG;
    private int GY_SG;
    private int GY_WSG;
    private int MU;
    private int TH;
    private final ArrayList<Student> alle;
    private int ethik;
    private int evangelisch;
    //Variablen--------------------------
    private final int jahrgang;
    private int katholisch;
    private final ArrayList<Klasse> klassen;
    private int klassenanzahl;
    private int maennlich;
    private boolean nachReligion;
    private boolean nachSport;
    private boolean nachSprache;
    private boolean nachZweig;
    private ArrayList<GruppeReligion> religionsgruppen;
    private int religionsgruppenzahl;
    private int schuelerAnzahl;
    private ArrayList<GruppeSport> sportgruppen;
    private int sportgruppenzahl;
    private ArrayList<GruppeSprache> sprachengruppen;
    private int sprachengruppenzahl;
    private int weiblich;
    private ArrayList<GruppeZweig> zweiggruppen;
    private int zweiggruppenzahl;

    public Jahrgang(int n) {

        klassen = new ArrayList<>();
        sportgruppen = new ArrayList<>();
        religionsgruppen = new ArrayList<>();
        zweiggruppen = new ArrayList<>();
        sprachengruppen = new ArrayList<>();
        jahrgang = n;
        alle = new ArrayList<>();

        String[] klassennamen = {"a", "b", "c", "d", "e", "f", "g", "h"};

        for (String s : klassennamen) {
            klassen.add(new Klasse(s, this));
        }
    }

    public void ausgabeAlle() {
        for (Student student : alle) {
            System.out.println(student);
        }
    }

    public void clearReligionsgruppen() {
        religionsgruppen = new ArrayList<>();
        this.religionsgruppenzahl = 0;
    }

    public void clearSportgruppen() {
        sportgruppen = new ArrayList<>();
        this.sportgruppenzahl = 0;
    }

    public void clearSprachengruppen() {
        sprachengruppen = new ArrayList<>();
        this.sprachengruppenzahl = 0;
    }

    public void clearZweiggruppen() {
        zweiggruppen = new ArrayList<>();
        this.zweiggruppenzahl = 0;
    }

    public ArrayList<Student> getAlle() {
        return alle;
    }

    public int getEthik() {
        return ethik;

    }

    public int getEvangelisch() {
        return evangelisch;
    }

    public int getGY() {
        return GY;
    }

    public int getGY_MU() {
        return MU;
    }

    public int getGY_NTG() {
        return GY_NTG;
    }

    public int getGY_SG() {
        return GY_SG;
    }

    public int getGY_TH() {
        return TH;
    }
    public int getGY_WSG() {
        return GY_WSG;
    }

    //Methoden---------------------------
    public int getJahrgang() {
        return jahrgang;

    }

    public int getKatholisch() {
        return katholisch;
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

    public int getMaennlich() {
        return maennlich;
    }

    public ArrayList<GruppeReligion> getReligionsgruppen() {

        return religionsgruppen;
    }

    public int getReligionsgruppenzahl() {
        return religionsgruppen.size();
    }

    public int getSchuelerAnzahl() {
        return alle.size();
    }

    public ArrayList<GruppeSport> getSportgruppen() {

        return sportgruppen;
    }

    public int getSportgruppenzahl() {
        return sportgruppen.size();
    }

    public ArrayList<GruppeSprache> getSprachengruppen() {

        return sprachengruppen;
    }

    public int getSprachengruppenzahl() {
        return sprachengruppen.size();
    }

    public int getWeiblich() {
        return weiblich;
    }

    public ArrayList<GruppeZweig> getZweiggruppen() {

        return zweiggruppen;
    }

    public int getZweiggruppenzahl() {
        return zweiggruppen.size();

    }

    //in alle gruppen des jahrgangs einfügen
    public void gruppenAdd(Student s) {
        if (istNachReligion()) {
            religionsgruppenAdd(s);
        }

        if (istNachZweig()) {
            zweiggruppenAdd(s);
        }

        if (istNachSprache()) {
            sprachengruppenAdd(s);
//
        }

        if (istNachSport()) {
            sprachengruppenAdd(s);
        }

    }

    public void gruppenAktualisieren(Student s) {

        for (GruppeReligion g : religionsgruppen) {
            g.aktualisiereSchueler(s);
        }

        for (GruppeSprache g : sprachengruppen) {
            g.aktualisiereSchueler(s);
        }

        for (GruppeZweig g : zweiggruppen) {
            g.aktualisiereSchueler(s);
        }

        for (GruppeSport g : sportgruppen) {
            g.aktualisiereSchueler(s);
        }
    }

    public void gruppenRemove(Student s) {
        religionsgruppenRemove(s);
        sportgruppenRemove(s);
        sprachengruppenRemove(s);
        zweiggruppenRemove(s);
    }

    public boolean istNachReligion() {
        return nachReligion;
    }

    public boolean istNachSport() {
        return nachSport;
    }

    public boolean istNachSprache() {
        return nachSprache;
    }

    public boolean istNachZweig() {
        return nachZweig;
    }

    public void religionsgruppeErstellen(String religion) {
        GruppeReligion re = new GruppeReligion(this, religion);
        religionsgruppenzahl++;
        religionsgruppen.add(re);
    }

    public void religionsgruppenAdd(Student student) {
        for (GruppeReligion aktuelleRG : religionsgruppen) {
            String religion = aktuelleRG.getReligion();
            String[] klassenBuchstaben = aktuelleRG.getKlassen();
            List<String> klassenList = Arrays.asList(klassenBuchstaben);

            if (klassenList.contains(student.getKlasse()) && student.getReligion().equals(aktuelleRG.getReligion())) {
                System.out.println(aktuelleRG.getTitel() + aktuelleRG + " Add Student: " + student);
                aktuelleRG.addSchueler(student);
                break;
            }
        }

    }
    /*
     public void religionsgruppenKlasseHinzufügen(int religionsgruppe, String buchstabe) {

     religionsgruppen.get(religionsgruppe + 1).klasseHinzufügen(buchstabe);
        
     switch (buchstabe) {
     case "a":
     for (int i = 0; i < klassen.get(0).getKlassengroesse(); i++) {
     if (klassen.get(0).getSchueler().get(i).getGeschlecht().equals(buchstabe)) {
     religionsgruppen.get(religionsgruppe).addSchueler(klassen.get(0).getSchueler().get(i)); 
     }
     }
     break;
     case "b":
     for (int i = 0; i < klassen.get(1).getKlassengroesse(); i++) {
     if (klassen.get(1).getSchueler().get(i).getGeschlecht().equals(buchstabe)) {
     religionsgruppen.get(religionsgruppe).addSchueler(klassen.get(1).getSchueler().get(i)); 
     }
     }
     break;
     case "c":
     for (int i = 0; i < klassen.get(2).getKlassengroesse(); i++) {
     if (klassen.get(2).getSchueler().get(i).getGeschlecht().equals(buchstabe)) {
     religionsgruppen.get(religionsgruppe).addSchueler(klassen.get(2).getSchueler().get(i)); 
     }
     }
     break;
     case "d":
     for (int i = 0; i < klassen.get(3).getKlassengroesse(); i++) {
     if (klassen.get(3).getSchueler().get(i).getGeschlecht().equals(buchstabe)) {
     religionsgruppen.get(religionsgruppe).addSchueler(klassen.get(3).getSchueler().get(i)); 
     }
     }
     break;
     case "e":
     for (int i = 0; i < klassen.get(4).getKlassengroesse(); i++) {
     if (klassen.get(4).getSchueler().get(i).getGeschlecht().equals(buchstabe)) {
     religionsgruppen.get(religionsgruppe).addSchueler(klassen.get(4).getSchueler().get(i)); 
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
     */

    public void religionsgruppenRemove(Student student) {

        for (GruppeReligion aktuelleGruppe : religionsgruppen) {
            Student removableStudent = null;

            for (Student s : aktuelleGruppe.getSchueler()) {

                if (s.istGleich(student)) {
                    removableStudent = s;

                }
            }
            if(removableStudent!=null){
                System.out.println(aktuelleGruppe.getTitel() + aktuelleGruppe + " Remove Student: " + student);
                aktuelleGruppe.removeSchueler(removableStudent);
                
            }
            

        }

    }

    /**
     * Ordnet die Schüler den entsprechenden Religionsgruppen zu.
     */
    public void religionsgruppenZuordnen() {
        int i = 1;
        for (GruppeReligion aktuelleRG : religionsgruppen) {
            String religion = aktuelleRG.getReligion();
            //System.out.println("ReliGruppe " + i + ": " + religion);
            String[] klassenBuchstaben = aktuelleRG.getKlassen();
            //System.out.println("Klassen:" + Arrays.toString(klassenBuchstaben) + "\n");

            List<String> klassenList = Arrays.asList(klassenBuchstaben);
            //System.out.println("Klassen in List:" + klassenList + "\n");

            for (Klasse k : klassen) {
                if (k.getKlassengroesse() > 0) {
                    for (Student student : k.getSchueler()) {
                        if (klassenList.contains(student.getKlasse()) && student.getReligion().equals(aktuelleRG.getReligion())) {
                            aktuelleRG.addSchueler(student);
                        }
                    }
                }
            }

        }
    }

    public void removeStudent(Student s) {
        alle.remove(s); // aus Jahrgang entfernt

        for (Klasse k : getKlassen()) {
            if (k.getSchueler().contains(s)) {
                k.removeSchueler(s);
            }

        }

        religionsgruppenRemove(s);
        sportgruppenRemove(s);
        sprachengruppenRemove(s);
        zweiggruppenRemove(s);
        studentAusStatistikEntfernen(s);

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

    public void setNachGeschlecht(boolean b) {
        //nachReligion = false;
        nachSport = b;
        //nachFremdsprache = false;
    }

    public void setNachReligion(boolean b) {
        nachReligion = b;
        //nachZweig = false;
        //nachFremdsprache = false;
    }

    public void setNachSprache(boolean b) {
        //nachReligion = false;
        //nachZweig = false;
        nachSprache = b;
    }

    public void setNachZweig(boolean b) {
        //nachReligion = false;
        nachZweig = b;
        //nachFremdsprache = false;
    }

    public void sportgruppeErstellen(String geschlecht) {
        GruppeSport sp = new GruppeSport(this, geschlecht);
        sportgruppenzahl++;
        sportgruppen.add(sp);
    }
    /*
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
     */

    public void sportgruppenAdd(Student student) {
        for (GruppeSport aktuelleRG : sportgruppen) {
            String geschlecht = aktuelleRG.getGeschlecht();
            String[] klassenBuchstaben = aktuelleRG.getKlassen();
            List<String> klassenList = Arrays.asList(klassenBuchstaben);
            if (klassenList.contains(student.getKlasse()) && student.getGeschlecht().equals(aktuelleRG.getGeschlecht())) {
                aktuelleRG.addSchueler(student);
                break;
            }
        }

    }

    public void sportgruppenRemove(Student student) {
        for (GruppeSport aktuelleGruppe : sportgruppen) {
            Student removableStudent = null;

            for (Student s : aktuelleGruppe.getSchueler()) {

                if (s.istGleich(student)) {
                    removableStudent = s;

                }
            }
            aktuelleGruppe.removeSchueler(removableStudent);
        }
    }

    /**
     * Ordnet die Schüler den entsprechenden Sportgruppen zu.
     */
    public void sportgruppenZuordnen() {
        int i = 1;
        for (GruppeSport aktuelleRG : sportgruppen) {
            String geschlecht = aktuelleRG.getGeschlecht();
            //System.out.println("ReliGruppe " + i + ": " + religion);
            String[] klassenBuchstaben = aktuelleRG.getKlassen();
            //System.out.println("Klassen:" + Arrays.toString(klassenBuchstaben) + "\n");

            List<String> klassenList = Arrays.asList(klassenBuchstaben);
            //System.out.println("Klassen in List:" + klassenList + "\n");

            for (Klasse k : klassen) {
                if (k.getKlassengroesse() > 0) {
                    for (Student student : k.getSchueler()) {
                        if (klassenList.contains(student.getKlasse()) && student.getGeschlecht().equals(aktuelleRG.getGeschlecht())) {
                            aktuelleRG.addSchueler(student);
                        }
                    }
                }
            }

        }
    }

    public void sprachengruppeErstellen(String fremdsprache, int wievielte) {
        GruppeSprache fg = new GruppeSprache(this, fremdsprache, wievielte);
        sprachengruppenzahl++;
        sprachengruppen.add(fg);
    }

    public void sprachengruppenAdd(Student student) {
        ArrayList<String> sprachenSchueler = new ArrayList<>();
        sprachenSchueler.add(student.getFs2());
        sprachenSchueler.add(student.getFs3());
        sprachenSchueler.add(student.getFs4());
        for (GruppeSprache sg : sprachengruppen) {

            if (sg.contains(student.getKlasse()) && sprachenSchueler.contains(sg.getSprache())) {
                sg.addSchueler(student);
                break;
            }
        }
    }

    /*
     public void sprachengruppenKlasseHinzufügen(int fremdsprachengruppe, String buchstabe) {

     sprachengruppen.get(fremdsprachengruppe + 1).klasseHinzufügen(buchstabe);
     switch (buchstabe) {
     case "a":
     for (int i = 0; i < klassen.get(0).getKlassengroesse(); i++) {
     if (klassen.get(0).getSchueler().get(i).getZweig().equals(buchstabe)) {
     sprachengruppen.get(fremdsprachengruppe).studentHinzufuegen(klassen.get(0).getSchueler().get(i));
     }
     }
     break;
     case "b":
     for (int i = 0; i < klassen.get(1).getKlassengroesse(); i++) {
     if (klassen.get(1).getSchueler().get(i).getZweig().equals(buchstabe)) {
     sprachengruppen.get(fremdsprachengruppe).studentHinzufuegen(klassen.get(1).getSchueler().get(i));
     }
     }
     break;
     case "c":
     for (int i = 0; i < klassen.get(2).getKlassengroesse(); i++) {
     if (klassen.get(2).getSchueler().get(i).getZweig().equals(buchstabe)) {
     sprachengruppen.get(fremdsprachengruppe).studentHinzufuegen(klassen.get(2).getSchueler().get(i));
     }
     }
     break;
     case "d":
     for (int i = 0; i < klassen.get(3).getKlassengroesse(); i++) {
     if (klassen.get(3).getSchueler().get(i).getZweig().equals(buchstabe)) {
     sprachengruppen.get(fremdsprachengruppe).studentHinzufuegen(klassen.get(3).getSchueler().get(i));
     }
     }
     break;
     case "e":
     for (int i = 0; i < klassen.get(4).getKlassengroesse(); i++) {
     if (klassen.get(4).getSchueler().get(i).getZweig().equals(buchstabe)) {
     sprachengruppen.get(fremdsprachengruppe).studentHinzufuegen(klassen.get(4).getSchueler().get(i));
     }
     }
     break;
     case "f":
     for (int i = 0; i < klassen.get(5).getKlassengroesse(); i++) {
     if (klassen.get(5).getSchueler().get(i).getZweig().equals(buchstabe)) {
     sprachengruppen.get(fremdsprachengruppe).studentHinzufuegen(klassen.get(5).getSchueler().get(i));
     }
     }
     break;
     case "g":
     for (int i = 0; i < klassen.get(6).getKlassengroesse(); i++) {
     if (klassen.get(6).getSchueler().get(i).getZweig().equals(buchstabe)) {
     sprachengruppen.get(fremdsprachengruppe).studentHinzufuegen(klassen.get(6).getSchueler().get(i));
     }
     }
     break;
     }
     }
     */
    public void sprachengruppenRemove(Student student) {
        for (GruppeSprache aktuelleGruppe : sprachengruppen) {
            Student removableStudent = null;

            for (Student s : aktuelleGruppe.getSchueler()) {

                if (s.istGleich(student)) {
                    removableStudent = s;

                }
            }
            aktuelleGruppe.removeSchueler(removableStudent);
        }
    }

    /**
     * Ordnet die Schüler den entsprechenden Fremdsprachengruppen zu.
     */
    public void sprachengruppenZuordnen() {
        int i = 0;
        for (GruppeSprache aktuelleSG : sprachengruppen) {
            i++;
            String fremdsprache = aktuelleSG.getSprache();
            int wievielte = aktuelleSG.getWievielteSprache();
            String[] klassenBuchstaben = aktuelleSG.getKlassen();
            List<String> klassenList = Arrays.asList(klassenBuchstaben);

            System.out.println("Gruppe " + i + ": Sprache: " + fremdsprache + " Folge: " + wievielte);
            System.out.println("Klassen:" + Arrays.toString(klassenBuchstaben));
            System.out.println("Klassen in List:" + klassenList + "\n");

            /*
             Beim Zuordnen der Schüler zu den Sprachengruppen ergibt sich das Problem, die wievielte Sprache soll eigentlich 
             abgefragt werden. Stand ist: L und F gibt es nur als 2. FS, Sp ist immer 3. FS, aber Sps ist 3. FS für die Schüler 
             aus dem Gymnasium und 2. FS für Schüler in der Übertrittsklasse. Die Schüler werden auch häufig in einer Gruppe 
             unterrichtet.	
             Es wird für jeden Studenten eine Liste der Sprachen angelegt. Enthält die Liste der Sprachen die Fremdsprache 
             der aktuellen Gruppe und enthält die Liste der Klassen für die aktuelle Gruppe die Klasse des Studenten, so wird 
             der Student zur Gruppe hinzugefügt.
             */
            for (Klasse k : klassen) {
                if (k.getKlassengroesse() > 0) {
                    for (Student student : k.getSchueler()) {
                        List<String> sprachenList = new ArrayList<>();
                        sprachenList.add(student.getFs2());
                        sprachenList.add(student.getFs3());
                        sprachenList.add(student.getFs4());

                        if (klassenList.contains(student.getKlasse()) && sprachenList.contains(fremdsprache)) {
                            aktuelleSG.addSchueler(student);
                        }
                    }
                }
            }

        }
    }

    public void studentAusStatistikEntfernen(Student s) {

        schuelerAnzahl--;
        switch (s.getGeschlecht()) {
            case "M":
                maennlich--;
                break;
            case "W":
                weiblich--;
                break;
        }
        switch (s.getReligion()) {
            case "RK":
                katholisch--;
                break;
            case "EV":
                evangelisch--;
                break;
            case "ETH":
                ethik--;
                break;
        }
        switch (s.getZweig()) {
            case "GY":
                GY--;
                break;
            case "GY_MU":
                MU--;
                break;
            case "GY_TH":
                TH--;
                break;
            case "GY_NTG_8":
                GY_NTG--;
                break;
            case "GY_WSG-S_8":
                GY_WSG--;
                break;
            case "GY_SG_8":
                GY_SG--;
                break;
        }
    }

    public void studentEinfuegen(Student s) {
        alle.add(s);
        studentInStatistikEintragen(s);
        String buchstabe = s.getKlasse();
        this.getKlasse(buchstabe).addSchueler(s);
        gruppenAdd(s);

    }

    public void studentInStatistikEintragen(Student s) {
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
                MU++;
                break;
            case "GY_TH":
                TH++;
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

    public void testReligionsgruppen() {
        for (GruppeReligion rg : religionsgruppen) {
            System.out.println("Gruppe: " + rg.getReligion());
            for (Student s : rg.getSchueler()) {
                System.out.println(s);
            }
        }
    }

    public void zweiggruppeErstellen(String zweig) {
        GruppeZweig re = new GruppeZweig(this, zweig);
        zweiggruppenzahl++;
        zweiggruppen.add(re);
    }

    public void zweiggruppenAdd(Student student) {
        for (GruppeZweig aktuelleRG : zweiggruppen) {
            String zweig = aktuelleRG.getZweig();
            String[] klassenBuchstaben = aktuelleRG.getKlassen();
            List<String> klassenList = Arrays.asList(klassenBuchstaben);
            if (klassenList.contains(student.getKlasse()) && student.getZweig().equals(aktuelleRG.getZweig())) {
                aktuelleRG.addSchueler(student);
                break;
            }
        }

    }

    /*
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
     */
    public void zweiggruppenRemove(Student student) {
        for (GruppeZweig aktuelleGruppe : zweiggruppen) {
            Student removableStudent = null;

            for (Student s : aktuelleGruppe.getSchueler()) {

                if (s.istGleich(student)) {
                    removableStudent = s;

                }
            }
            aktuelleGruppe.removeSchueler(removableStudent);
        }
    }

    /**
     * Ordnet die Schüler den entsprechenden Zweiggruppen zu.
     */
    public void zweiggruppenZuordnen() {
        int i = 1;
        for (GruppeZweig aktuelleZG : zweiggruppen) {
            String zweig = aktuelleZG.getZweig();
            //System.out.println("ZweigGruppe " + i + ": " + zweig);
            String[] klassenBuchstaben = aktuelleZG.getKlassen();
            //System.out.println("Klassen:" + Arrays.toString(klassenBuchstaben) + "\n");

            List<String> klassenList = Arrays.asList(klassenBuchstaben);
            //System.out.println("Klassen in List:" + klassenList + "\n");

            for (Klasse k : klassen) {
                if (k.getKlassengroesse() > 0) {
                    for (Student student : k.getSchueler()) {
                        if (klassenList.contains(student.getKlasse()) && student.getZweig().equals(aktuelleZG.getZweig())) {
                            aktuelleZG.addSchueler(student);
                        }
                    }
                }
            }

        }
    }

}
