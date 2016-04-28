/**
 *
 * @author behl.claus
 */
package gruppeneinteilung;

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
        ASVImport asvImport = new ASVImport(filename);
        students = asvImport.parseLines();
        studentJahrgangZuordnen();
    }


    public Gruppeneinteilung() {
        students = new ArrayList<Student>();
        jahrgaenge = new ArrayList<>();
        for (int i = 5; i < 11; i++) {
            jahrgaenge.add(new Jahrgang(i));
        }

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
        studentJahrgangZuordnen();
    }

    void setFile(File file) {
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Gruppeneinteilung ge = new Gruppeneinteilung("ASV.csv");

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ge.testGruppenFenster();
            }
        });

    }

    /**
     *
     */
    public void testGruppenFenster() {
        GruppenFenster gf1 = new GruppenFenster(students, "Gesamtliste: " + students.size() + " Schüler");
    }

    public void testeEinteilung() {
        for (Jahrgang jahrgang : jahrgaenge) {
            System.out.println("--------------------");
            System.out.println();
            System.out.println("Jahrgang: " + jahrgang.getJahrgang());
            System.out.println("Anzahl: " + jahrgang.getSchuelerAnzahl());
            System.out.println();
            jahrgang.ausgabeAlle();
        }
    }

}
