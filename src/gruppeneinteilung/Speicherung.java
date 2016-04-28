/**
 *
 * @author mueller.fabian
 */
package gruppeneinteilung;

import java.io.*;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Speicherung {

    private Gruppeneinteilung ge;
    private File file;

    public Speicherung(Gruppeneinteilung ge) {
        this.ge = ge;
        if (ge.getFile() == null) {
            file = new FileAuswahl().waehleFile();
        } else {
            file = ge.getFile();
        }
    }

    public Speicherung(String filename) {
        file = new File(filename);
        ge = new Gruppeneinteilung();
        ge.setFile(file);
    }

    public Speicherung() {
        ge = new Gruppeneinteilung();
        file = new FileAuswahl().waehleFile();
        ge.setFile(file);
    }

    public void speichern() {

        try {
            FileOutputStream fileStream = new FileOutputStream(file);
            ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
            objectStream.writeObject(ge.getStudents());
            objectStream.writeObject(ge.getJahrgaenge());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void speichernUnter(){
        file = new FileAuswahl().waehleFile();
        ge.setFile(file);
        speichern();
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
                            ge.getStudents().add(v);
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

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ge;
    }

    

    public void testeLaden() {
        serialisierungLaden();
        ge.testeEinteilung();

    }
    
     public static void main(String[] args) {
        //Speicherung sp = new Speicherung(new Gruppeneinteilung("ASV.csv"));
        //sp.serialisieren();
        Speicherung sp = new Speicherung();
        sp.testeLaden();
    }

}

class FileAuswahl{
    File file;
    public FileAuswahl() {
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
        file =fileGewaehlt;
    }
    
    public File waehleFile(){
        return file;
    }
}
