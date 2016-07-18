/**
 *
 * @author mueller.fabian
 */
package gruppeneinteilung.helper;

import gruppeneinteilung.model.Gruppeneinteilung;
import gruppeneinteilung.model.Jahrgang;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Speicherung {

    private Gruppeneinteilung ge;
    private File file;

    // Die zu speichernde Gruppeneinteilung wird übergeben
    public Speicherung(Gruppeneinteilung ge) {
        this.ge = ge;
        file = ge.getFile();
        
    }
    
    // Die Datei wird übergeben aus der Die Gruppeneinteilung gelsesn werden soll.
    public Speicherung(File file) {
        ge = new Gruppeneinteilung();
        if (file == null) {
            file = new FileAuswahl("open").getFile();
            ge.setFile(file);
        }
    }

    // Die Gruppeneinteilung wird aus einer zu wählenden Datei gelesen
    public Speicherung() {
        ge = new Gruppeneinteilung();
        file = new FileAuswahl("open").getFile();
        ge.setFile(file);
    }
    
    public void speichern() {
        if (file == null) {
            file = new FileAuswahl("save").getFile();
            ge.setFile(file);
        }
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
        file = new FileAuswahl("save").getFile();
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

    public FileAuswahl(String art) {
        File fileGewaehlt = null;
        JFileChooser chooser = new JFileChooser(new File(System.getProperty("user.dir")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "GED-Datei", "ged");
        chooser.setFileFilter(filter);
        int returnVal=0;
        if(art.equals("save")){
            returnVal = chooser.showSaveDialog(null);
        }
        if(art.equals("open")){
            returnVal = chooser.showOpenDialog(null);
        }
        
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
