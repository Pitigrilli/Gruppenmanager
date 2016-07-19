/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppeneinteilung.helper;

import gruppeneinteilung.model.Student;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Claus Behl
 */
public class ASVImport {

    private File asvexport;
    private final List<String> lines;

    public ASVImport() {
        JFileChooser chooser = new JFileChooser(new File(System.getProperty("user.dir")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "ASV-Import", "csv");
        chooser.setFileFilter(filter);
        int returnVal;
        returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            //System.out.println("You chose to open this file: "
            //        + chooser.getSelectedFile().getName());
            asvexport = chooser.getSelectedFile();
        }
        lines = readFile();
    }

    public ASVImport(String filename) {

        asvexport = new File(filename);

        lines = readFile();
    }

    /**
     *
     * @return Liste der Schüler, aus dem aktuellen Import
     */
    public ArrayList<Student> parseLines() {
        ArrayList<Student> students = new ArrayList<>();
        if (asvexport != null) {
            lines.stream().forEach((String line) -> {
                String[] tokens;
                tokens = line.split(";", -1);
                if (tokens[0].length() > 1 && Character.isDigit(tokens[0].charAt(0))) {
                    Student s;
                    int jahrgang = Integer.parseInt(tokens[0].substring(0, 2));

                    String klasse = tokens[0].substring(2);
                    s = new Student(jahrgang, klasse, tokens[1], tokens[2], tokens[3], tokens[5], tokens[6], tokens[7], tokens[8]);
                    //System.out.println(jahrgang + "\t" + klasse + "\t" + s);
                    s.setBemerkung("");
                    if (jahrgang < 11 && jahrgang > 4) { // Schüler aus nicht benötigten Jahrgängen werden verworfen
                        students.add(s);
                    }
                }

            });
        }
        return students;
    }

    private List<String> readFile() {
        List<String> records = new ArrayList<>();
        String filename;
        filename = "empty";

        try (
                
                BufferedReader reader = 
                new BufferedReader(
           new InputStreamReader(
                      new FileInputStream(asvexport), "UTF8"));
                
               // new BufferedReader(new FileReader(asvexport))
                ) {
            filename = asvexport.getCanonicalPath();
            String line;
            while ((line = reader.readLine()) != null) {
                records.add(line);
            }

            return records;
        } catch (Exception e) {
            System.err.format("Exception occurred trying to read '%s'.", filename);
            return null;
        }
    }

}
