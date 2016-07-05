/**
 *
 * @author behl.claus
 */
package gruppeneinteilung.model;

import gruppeneinteilung.helper.ASVImport;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class Gruppeneinteilung implements Serializable {

    private ArrayList<Student> students;
    private final ArrayList<Jahrgang> jahrgaenge;
    private Jahrgang aktJahrgang;

    private File file;
    /*
     Folgender Konstruktor wird nur zum Testen benötigt
     */

    public Gruppeneinteilung(String filename) {
        this();
        for (int i = 5; i < 11; i++) {
            jahrgaenge.add(new Jahrgang(i));
        }
        ASVImport asvImport = new ASVImport(filename);
        students = asvImport.parseLines();
        studentJahrgangZuordnen();
        for (int i = 0; i < 6; i++) {
            jahrgaenge.get(i).setKlassenanzahl();
        }
    }

    public Gruppeneinteilung() {
        students = new ArrayList<Student>();
        jahrgaenge = new ArrayList<>();
        /*for (int i = 5; i < 11; i++) {
            jahrgaenge.add(new Jahrgang(i));
        }*/

    }

    public void studentJahrgangZuordnen() {
        for (Student aktuell : students) {
            int j = aktuell.getJahrgang();
            jahrgaenge.get(j - 5).studentEinfuegen(aktuell);
        }
    }

    public void asvImport() {
        ASVImport asvImport = new ASVImport();
        students = asvImport.parseLines();
        for (int i = 5; i < 11; i++) {
            jahrgaenge.add(new Jahrgang(i));
        }
        studentJahrgangZuordnen();
        for (int i = 0; i < 6; i++) {
            jahrgaenge.get(i).setKlassenanzahl();
        }
    }

    public void setFile(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public void setAktJahrgang(Jahrgang aktJahrgang) {
        this.aktJahrgang = aktJahrgang;
    }
    
    
    public Jahrgang getAktJahrgang() {
        return aktJahrgang;
    }

    public Jahrgang getJahrgang(int n) {
        return jahrgaenge.get(n - 5);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Jahrgang> getJahrgaenge() {
        return jahrgaenge;
    }

    public void testeEinteilung() {
        for (Jahrgang jahrgang : jahrgaenge) {
            System.out.println("--------------------");
            System.out.println();
            System.out.println("Jahrgang: " + jahrgang.getJahrgang());
            System.out.println("Anzahl Klassen: " + jahrgang.getKlassenanzahl());
            System.out.println("Anzahl Schüler: " + jahrgang.getSchuelerAnzahl());
            System.out.println();
            //jahrgang.printAlle();
        }
    }
   


public void moveStudent(Student s, int j)
{
    if(j<= 10 && j >= 5)
    {
    s.setJahrgang(j);
    removeStudent(s);
    jahrgaenge.get(s.getJahrgang()).studentAusStatistikEntfernen(s);
    addInGroups(s);
    }
}

//in alle gruppen des jahrgangs einfügen
public void addInGroups(Student s){
      Jahrgang ak = getJahrgaenge().get(s.getJahrgang());
     ak.studentEinfuegen(s);
     
}

 public void removeStudent(Student s){// ok, ich hoffe die anzahl der klassen und gruppen sind richtig, oder Alternative s. U.
    Jahrgang jg = getJahrgang(s.getJahrgang()); 
   jg.gibAlle().remove(s); // aus Jahrgang entfernt
   for(int i = 0; i < jg.getKlassenanzahl(); i++)//for(Klasse k: jg.getKlassen())
   {
       if(jg.getKlassen().get(i).getSchueler().contains(s))// if(k.contains(s))
       {
          jg.getKlassen().get(i).getSchueler().remove(s); //aus Klasse entfernt, k.removeSchueler(s);
       }
       
   }
   for(int i = 0; i < jg.getReligionsgruppenzahl(); i++)
   {
       if(jg.getReligionsgruppen().get(i).getSchueler().contains(s))
       {
          jg.getReligionsgruppen().get(i).getSchueler().remove(s); //aus Religruppe entfernt
       }
       
   }
   for(int i = 0; i < jg.getZweiggruppenzahl(); i++)
   {
       if(jg.getZweiggruppen().get(i).getSchueler().contains(s))
       {
          jg.getZweiggruppen().get(i).getSchueler().remove(s); //aus Zweiggruppe entfernt
       }
       
   }
   for(int i = 0; i < jg.getSprachengruppenzahl(); i++)
   {
       if(jg.getSprachengruppen().get(i).getSchueler().contains(s))
       {
          jg.getSprachengruppen().get(i).getSchueler().remove(s); //aus Sprachengruppe entfernt
       }
       
   }
   for(int i = 0; i < jg.getSportgruppenzahl(); i++)
   {
       if(jg.getSportgruppen().get(i).getSchueler().contains(s))
       {
          jg.getSportgruppen().get(i).getSchueler().remove(s); //aus Sportgruppe entfernt
       }
       
   }
   students.remove(s);
   
    
}
}

