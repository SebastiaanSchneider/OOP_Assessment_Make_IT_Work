package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Klasse voor het representeren van een verzekeringskantoor.
 */
public class Verzekeringskantoor {
    private String naam;
    private String plaats;
    private List<Polis> polissen;


    // Constructor initialisatie
    public Verzekeringskantoor(String naam, String plaats) {
        this.naam = naam;
        this.plaats = plaats;
        this.polissen = new ArrayList<>();
    }

    // Methode om een polis toe te voegen
    public void voegPolisToe(Polis polis) {
        polissen.add(polis);
    }

    // Geeft een gesorteerde stringrepresentatie van alle polissen van dit kantoor
    @Override
    public String toString() {
        Collections.sort(polissen);
        StringBuilder result = new StringBuilder();
        result.append(String.format("Polissen bij Verzekeringskantoor %s te %s:\n", naam, plaats));
        for (Polis polis : polissen) {
            result.append(polis).append("\n");
        }
        return result.toString();
    }
}
