/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppeneinteilung;

import java.util.ArrayList;

/**
 *
 * @author schwindt.christian
 */
public class Klasse {
    
    private int jahrgang;
    private String buchstabe;
    

    private ArrayList<Student> schueler;
    
    public Klasse(String s, int j){
        buchstabe=s;
        jahrgang = j;
        schueler = new ArrayList<Student>();
    }
    
    public void studentHinzufuegen(Student s){
        schueler.add(s);
        
        
    }
    
    public void studentEntfernen(Student s){
        schueler.remove(s);
        
    }
    
    public int getKlassengroesse(){
        return schueler.size();
    }
    
    
}
