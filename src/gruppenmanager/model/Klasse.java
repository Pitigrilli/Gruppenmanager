package gruppenmanager.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author schwindt.christian
 */
public class Klasse extends SortierbareGruppe implements Serializable {

    private final Jahrgang jahrgang;
    private final String buchstabe;

    public Klasse(String b, Jahrgang j) {
        buchstabe = b;
        jahrgang = j;
        schueler = new ArrayList<>();
    }

    public int getKlassengroesse() {
        return schueler.size();
    }

    public String getBuchstabe() {
        return buchstabe;
    }

    public String getTitel() {
        titel = jahrgang.getJahrgang() + getBuchstabe() + ": ";
        return titel;
    }

    public void aktualisiereKlassen() {
    }

}
