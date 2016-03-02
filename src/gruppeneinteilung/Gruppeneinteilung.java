/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppeneinteilung;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 *
 * @author behl.claus
 */
public class Gruppeneinteilung {
    List<Student> students; 

    public Gruppeneinteilung(){
        ASVImport asvImport = new ASVImport();
        //asvImport.testReadFile();
        students = asvImport.parseLines();
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
        Student[] studentliste = students.toArray(new Student[students.size()]);
        //Arrays.sort(studentliste);
        GruppenFenster gf1 = new GruppenFenster(studentliste, "Gesamtliste: "+students.size()+" Schüler");
    }

    

}
