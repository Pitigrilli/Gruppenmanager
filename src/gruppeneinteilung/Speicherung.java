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
    
    public static void serialisieren(){
        try{
            FileOutputStream fileStream = new FileOutputStream("serialisierung.ser");
            ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
            objectStream.writeObject(Gruppeneinteilung.students);
            objectStream.writeObject(Gruppeneinteilung.jahrgaenge);
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public static void serialisierungLaden(){
        try{
            FileInputStream fileStream = new FileInputStream("serialisierung.ser");
            ObjectInputStream objectStream = new ObjectInputStream(fileStream);
            Gruppeneinteilung.students = (ArrayList<Student>) objectStream.readObject();
            Gruppeneinteilung.jahrgaenge = (ArrayList<Jahrgang>) objectStream.readObject();
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}
