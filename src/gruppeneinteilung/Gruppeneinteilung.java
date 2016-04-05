package gruppeneinteilung;


import java.util.ArrayList;
import java.util.Arrays;


/**
 *
 * @author behl.claus
 */
public class Gruppeneinteilung {
    ArrayList<Student> students;
    ArrayList<Jahrgang> jahrgaenge;

    public Gruppeneinteilung(){
        ASVImport asvImport = new ASVImport();
        //asvImport.testReadFile();
        students = asvImport.parseLines();
        jahrgängeErstellen();
        
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
    public void testGruppenFenster(){
        /*
        Student[] studentliste = new Student[4];
        studentliste[0] = new Student("","Hans","","","","","","");
        studentliste[1] = new Student("","Grete","","","","","","");
        studentliste[2] = new Student("","Albert","","","","","","");
        studentliste[3] = new Student("","Franz","","","","","","");
        for (int i = 0; i < 4; i++) {
            System.out.println(studentliste[i].getName());
        }
             */

        GruppenFenster gf1 = new GruppenFenster(students, "Gesamtliste: "+students.size()+" Schüler");
    }
    
    public void jahrgängeErstellen()
    {
        for(int i = 5; i < 11; i++)
        jahrgaenge.add(new Jahrgang(i));
    }
    
    //studentEinfuegen
    public void studentJahrgangZuordnen(){
        for(int i=0;i<students.size();i++){
            Student aktuell=students.get(i);
            int j= aktuell.getJahrgang();
            jahrgaenge.get(j-5).studentEinfuegen(aktuell);
    }
    }
}
