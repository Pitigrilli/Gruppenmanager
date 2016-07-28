package gruppeneinteilung.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author schwindt.christian
 */
public class GruppeReligion extends SortierbareGruppe implements Serializable {

    /**
     * Liste der Buchstaben der zugehörigen Klassen
     */
    private String[] klassen;
    private String religion;

    public GruppeReligion(Jahrgang j, String r) {
        jahrgang = j;
        schueler = new ArrayList<>();
        religion = r;
        klassen = new String[8];
    }

    public void aktualisiereKlassen() {
        klassen = new String[8];
        ArrayList<String> klassenList = new ArrayList<>();
        for (Student s : schueler) {
            if (!klassenList.contains(s.getKlasse())) {
                klassenList.add(s.getKlasse());
            }
        }
        klassen = klassenList.toArray(new String[0]);
        Arrays.sort(klassen);
    }

    public boolean contains(String k) {
        List<String> list = Arrays.asList(klassen);
        return list.contains(k);
    }

    public Jahrgang getJahrgang() {
        return jahrgang;
    }

    public String[] getKlassen() {
        return klassen;
    }

    public String getReligion() {
        return religion;
    }

    public int getReligiongroesse() {
        return schueler.size();
    }

    public String getTitel() {
        titel = getReligion() + " " + Arrays.toString(klassen) + ": ";
        return titel;
    }

    public void klasseHinzufügen(String k){
        int i = 0;
        while (klassen[i] != null) {
            i++;
        }
        klassen[i] = k;
    }

    public void setKlassen(String[] klassen) {
        this.klassen = klassen;
    }

    public void setReligion(String r) {
        religion = r;
    }
    
    

}
