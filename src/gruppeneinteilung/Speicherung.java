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
    
    public static void main(String[] args){
        Speicherung sp = new Speicherung(new Gruppeneinteilung("ASV.csv"));
        //sp.serialisieren();
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        sp.serialisierungLaden();
        sp.ge.testeEinteilung();
    }
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
            Object obj = objectStream.readObject();
            if (obj instanceof ArrayList<?>) {
                 ArrayList<?> al = (ArrayList<?>) obj;
                    if (al.size() > 0) {
                     // Iterate.
                         for (int i = 0; i < al.size(); i++) {
                          // Still not enough for a type.
                        Object o = al.get(i);
                              if (o instanceof Student) {
                                    Student v = (Student) o;
                                    ge.students.add(v);
                                }
                        }
                    }
            }
            obj = objectStream.readObject();
            if (obj instanceof ArrayList<?>) {
                 ArrayList<?> al = (ArrayList<?>) obj;
                    if (al.size() > 0) {
                     // Iterate.
                         for (int i = 0; i < al.size(); i++) {
                          // Still not enough for a type.
                        Object o = al.get(i);
                              if (o instanceof Jahrgang) {
                                    Jahrgang v = (Jahrgang) o;
                                    ge.jahrgaenge.add(v);
                                }
                        }
                    }
            }
                //ge.students = (ArrayList<Student>) objectStream.readObject();
                //ge.jahrgaenge = (ArrayList<Jahrgang>) objectStream.readObject();
            
            
            
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}
