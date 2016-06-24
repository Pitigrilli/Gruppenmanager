/**
 *
 * @author mueller.fabian
 */
package gruppeneinteilung.helper;

import gruppeneinteilung.model.Gruppeneinteilung;
import gruppeneinteilung.model.Student;
import gruppeneinteilung.model.Jahrgang;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Speicherung {

    private Gruppeneinteilung ge;
    private File file;

    public Speicherung(Gruppeneinteilung ge) {
        this.ge = ge;
        if (ge.getFile() == null) {
            file = new FileAuswahl().getFile();
            ge.setFile(file);
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
        file = waehleFile();
        ge.setFile(file);
    }
    
    public File waehleFile(){
        File fileNeu = new FileAuswahl().getFile();
        return fileNeu;
    }

    public void speichern() {
        try {
            FileOutputStream fileStream = new FileOutputStream(file, false);
            ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
            objectStream.writeObject(ge);//neu
//            objectStream.writeObject(ge.getStudents());
//            objectStream.writeObject(ge.getJahrgaenge());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void speichernUnter() {
        file = new FileAuswahl().getFile();
        ge.setFile(file);
        speichern();
    }

    public Gruppeneinteilung serialisierungLaden() {

        try {
            FileInputStream fileStream = new FileInputStream(file);
            ObjectInputStream objectStream = new ObjectInputStream(fileStream);
            Object obj = null;

            obj = objectStream.readObject();

            if (obj instanceof Gruppeneinteilung) {
                ge = (Gruppeneinteilung) obj;
            }
            ge.setFile(file);

        } catch (InvalidClassException ex) {
            JOptionPane.showMessageDialog(null, "Die GED-Datei ist ungültig. Laden Sie eine andere Datei\n"
                    + "oder importieren Sie eine ASV-Datei.");
        } catch (IOException ex) {
            Logger.getLogger(Speicherung.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Speicherung.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ge;
    }

    public void testeLaden() {
        ge = serialisierungLaden();
        //ge.testeEinteilung();
        for (Jahrgang j : ge.getJahrgaenge()) {
            System.out.println("Jahrgang " + j.getJahrgang() + ": " + j.getKlassenanzahl());
        }

    }

    public static void main(String[] args) {
        //Speicherung sp = new Speicherung(new Gruppeneinteilung("ASV.csv"));
        //sp.speichern();
        Speicherung sp = new Speicherung();
        sp.testeLaden();
    }

}

class FileAuswahl {

    File file;

    public FileAuswahl() {
        File fileGewaehlt = null;
        JFileChooser chooser = new JFileChooser(new File(System.getProperty("user.dir")));
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
        file = fileGewaehlt;
    }

    public File getFile() {
        return file;
    }
}
