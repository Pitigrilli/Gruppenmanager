/**
 *
 * @author behl.claus
 */
package gruppeneinteilung.model;

import gruppeneinteilung.helper.ASVImport;
import java.io.File;
import java.util.ArrayList;

public class Gruppeneinteilung {

    private ArrayList<Student> students;
    private final ArrayList<Jahrgang> jahrgaenge;
    private File file;
    /*
     Folgender Konstruktor wird nur zum Testen benötigt
     */

    public Gruppeneinteilung(String filename) {
        this();
        for (int i = 5; i < 11; i++) {
            jahrgaenge.add(new Jahrgang(i));
        }
        ASVImport asvImport = new ASVImport(filename);
        students = asvImport.parseLines();
        studentJahrgangZuordnen();
        for (int i = 0; i < 6; i++) {
            jahrgaenge.get(i).setKlassenanzahl();
        }
    }

    public Gruppeneinteilung() {
        students = new ArrayList<Student>();
        jahrgaenge = new ArrayList<>();
        /*for (int i = 5; i < 11; i++) {
            jahrgaenge.add(new Jahrgang(i));
        }*/

    }

    public void studentJahrgangZuordnen() {
        for (Student aktuell : students) {
            int j = aktuell.getJahrgang();
            jahrgaenge.get(j - 5).studentEinfuegen(aktuell);
        }
    }

    public void asvImport() {
        ASVImport asvImport = new ASVImport();
        students = asvImport.parseLines();
        for (int i = 5; i < 11; i++) {
            jahrgaenge.add(new Jahrgang(i));
        }
        studentJahrgangZuordnen();
        for (int i = 0; i < 6; i++) {
            jahrgaenge.get(i).setKlassenanzahl();
        }
    }

    public void setFile(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public Jahrgang getJahrgang(int n) {
        return jahrgaenge.get(n - 5);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Jahrgang> getJahrgaenge() {
        return jahrgaenge;
    }

    public void testeEinteilung() {
        for (Jahrgang jahrgang : jahrgaenge) {
            System.out.println("--------------------");
            System.out.println();
            System.out.println("Jahrgang: " + jahrgang.getJahrgang());
            System.out.println("Anzahl Klassen: " + jahrgang.getKlassenanzahl());
            System.out.println("Anzahl Schüler: " + jahrgang.getSchuelerAnzahl());
            System.out.println();
            //jahrgang.printAlle();
        }
    }

}
