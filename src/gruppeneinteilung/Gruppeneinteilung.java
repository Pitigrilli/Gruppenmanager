package gruppeneinteilung;

import java.util.ArrayList;

/**
 *
 * @author behl.claus
 */
public class Gruppeneinteilung {

    ArrayList<Student> students;
    private ArrayList<Jahrgang> jahrgaenge;



    public Gruppeneinteilung() {
        ASVImport asvImport = new ASVImport();
        students = asvImport.parseLines();
        jahrgaenge = new ArrayList<>();
        jahrgaengeErstellen();
        studentJahrgangZuordnen();
    }
    
        public Gruppeneinteilung(String filename) {
        ASVImport asvImport = new ASVImport(filename);
        students = asvImport.parseLines();
        jahrgaenge = new ArrayList<>();
        jahrgaengeErstellen();
        studentJahrgangZuordnen();
    }
        
    public Gruppeneinteilung(int i){
        students = new ArrayList<Student>();
        jahrgaenge = new ArrayList<Jahrgang>();
        jahrgaengeErstellen();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //testGruppenFenster();
        Gruppeneinteilung ge = new Gruppeneinteilung();
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
    
    public Jahrgang getJahrgang(int n){
        return jahrgaenge.get(n-5);
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
            System.out.println("Anzahl: " + jahrgang.getSchuelerAnzahl());
            System.out.println();
            jahrgang.ausgabeAlle();
        }
    }
}
