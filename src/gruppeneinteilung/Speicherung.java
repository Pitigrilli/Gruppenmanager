/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppeneinteilung;

import java.io.*;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author mueller.fabian
 */
public class Speicherung {

    public static void main(String[] args) {
        //Speicherung sp = new Speicherung(new Gruppeneinteilung("ASV.csv"));
        //sp.serialisieren();
        Speicherung sp = new Speicherung();
        sp.testeLaden();
    }
    Gruppeneinteilung ge;
    File file;
    

    public Speicherung(Gruppeneinteilung ge) {
        this.ge = ge;
        file=waehleFile();
    }

    public Speicherung(String filename) {
        ge = new Gruppeneinteilung(0);
    }
    
    public Speicherung(){
        ge = new Gruppeneinteilung(0);
        file=waehleFile();
    }

    public void serialisieren() {

        try {
            FileOutputStream fileStream = new FileOutputStream(file);
            ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
            objectStream.writeObject(ge.students);
            objectStream.writeObject(ge.getJahrgaenge());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Gruppeneinteilung serialisierungLaden() {
        
        try {
            FileInputStream fileStream = new FileInputStream(file);
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
                            ge.getJahrgaenge().add(v);
                        }
                    }
                }
            }
                //ge.students = (ArrayList<Student>) objectStream.readObject();
            //ge.jahrgaenge = (ArrayList<Jahrgang>) objectStream.readObject();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ge;
    }
    
    
    public File waehleFile(){
        File fileGewaehlt = null;
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "GED-Datei", "ged");
        chooser.setFileFilter(filter);
        int returnVal;
        returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            //System.out.println("You chose to open this file: "
            //        + chooser.getSelectedFile().getName());
            fileGewaehlt = chooser.getSelectedFile();
        }
        return file;
    }

    public void testeLaden() {
        serialisierungLaden();
        ge.testeEinteilung();

    }

}
