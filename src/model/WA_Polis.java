package model;

import java.time.LocalDate;

/**
 * Subklasse van Polis, voor Wettelijke Aansprakelijkheid (WA).
 */
public class WA_Polis extends Polis {
    public static final double CATEGORIE_PERCENTAGE_START = 0.07;
    public static final double DELER = 100.0;
    public static final int DEFAULT_AANTAL_PERSONEN = 1;

    private int aantalPersonen;


    // All-args constructor
    public WA_Polis(String naamPolishouder, int verzekerdBedrag,
                    LocalDate startDatum, int eigenRisico, int aantalPersonen) {
        super(naamPolishouder, verzekerdBedrag, startDatum, eigenRisico);
        this.aantalPersonen = aantalPersonen;
    }

    // Constructor met defaults
    public WA_Polis(String naamPolishouder, int verzekerdBedrag) {
        super(naamPolishouder, verzekerdBedrag, LocalDate.now(), 1);
        this.aantalPersonen = DEFAULT_AANTAL_PERSONEN;
    }


    // Berekening: premie = verzekerdBedrag * aangepaste factor * aantalPersonen
    @Override
    public double berekenJaarPremie() {
        return getVerzekerdBedrag() *
                (CATEGORIE_PERCENTAGE_START - ((double) eigenRisicoCategorie /
                        DELER)) * aantalPersonen;
    }

    // Methode voor nieuwe toString
    @Override
    public String toString() {
        return String.format("""
                Polis op naam van %s
                \tVerzekerd bedrag: %d euro
                \tStartdatum: %s
                \tEigen risico categorie: %d
                \tAantal personen: %d
                \tJaarpremie: %.2f euro""",
                naamPolishouder, verzekerdBedrag, startDatum,
                eigenRisicoCategorie, aantalPersonen, berekenJaarPremie());
    }
}
