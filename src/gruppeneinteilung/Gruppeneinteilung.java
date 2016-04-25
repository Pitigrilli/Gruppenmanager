package gruppeneinteilung;

import java.util.ArrayList;

/**
 *
 * @author behl.claus
 */
public class Gruppeneinteilung {

    ArrayList<Student> students;
    ArrayList<Jahrgang> jahrgaenge;

    public Gruppeneinteilung() {
        ASVImport asvImport = new ASVImport();
        //asvImport.testReadFile();
        students = asvImport.parseLines();
        jahrgaenge = new ArrayList<>();
        jahrgaengeErstellen();
        studentJahrgangZuordnen();
        testeEinteilung();
    }
    
        public Gruppeneinteilung(String filename) {
        ASVImport asvImport = new ASVImport(filename);
        //asvImport.testReadFile();
        students = asvImport.parseLines();
        jahrgaenge = new ArrayList<>();
        jahrgaengeErstellen();
        studentJahrgangZuordnen();
        testeEinteilung();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //testGruppenFenster();
        Gruppeneinteilung ge = new Gruppeneinteilung();
        GUI gui = new GUI();
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

    public void jahrgaengeErstellen() {
        for (int i = 5; i < 11; i++) {
            jahrgaenge.add(new Jahrgang(i));
        }
    }

    //studentEinfuegen
    public void studentJahrgangZuordnen() {
        for (Student aktuell : students) {
            int j = aktuell.getJahrgang();
            jahrgaenge.get(j - 5).studentEinfuegen(aktuell);
        }
    }

    public void testeEinteilung() {
        for (Jahrgang jahrgang : jahrgaenge) {
            System.out.println("--------------------");
            System.out.println();
            System.out.println("Jahrgang: " + jahrgang.getJahrgang());
            System.out.println("Anzahl: " + jahrgang.getSchülerAnzahl());
            System.out.println();
            jahrgang.ausgabeAlle();
        }
    }
}
