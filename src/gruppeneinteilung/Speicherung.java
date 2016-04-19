/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppeneinteilung;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author mueller.fabian
 */
public class Speicherung {
    Gruppeneinteilung ge;
    public Speicherung(Gruppeneinteilung ge){
        this.ge=ge;
    
    }
    
    public  void serialisieren(){
        try{
            FileOutputStream fileStream = new FileOutputStream("serialisierung.ser");
            ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
            objectStream.writeObject(ge.students);
            objectStream.writeObject(ge.jahrgaenge);
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public  void serialisierungLaden(){
        try{
            FileInputStream fileStream = new FileInputStream("serialisierung.ser");
            ObjectInputStream objectStream = new ObjectInputStream(fileStream);
            ge.students = (ArrayList<Student>) objectStream.readObject();
            ge.jahrgaenge = (ArrayList<Jahrgang>) objectStream.readObject();
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}
