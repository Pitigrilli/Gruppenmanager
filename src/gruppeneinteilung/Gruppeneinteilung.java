/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppeneinteilung;
import java.util.Arrays;
/**
 *
 * @author behl.claus
 */
public class Gruppeneinteilung {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Student s;
        s = new Student("Hans");
        Student[] studentliste = new Student[4];
        studentliste[0]= s;
        studentliste[1] = new Student("Grete");
        studentliste[2] = new Student("Albert");
        studentliste[3] = new Student("Franz");
        for(int i=0; i < 4; i++)
            System.out.println(studentliste[i].getName());
        
        Arrays.sort(studentliste);
        
        GruppenFenster gf1 = new GruppenFenster(studentliste, "09a");
        
    }
    
}
