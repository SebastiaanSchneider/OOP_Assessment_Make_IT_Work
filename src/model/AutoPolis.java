package model;

import java.time.LocalDate;

/**
 * Subklasse van Polis, specifiek voor autoverzekeringen.
 */
public class AutoPolis extends Polis {
    // Constanten voor berekening
    public static final int MINIMUM_SCHADEVRIJE_JAREN = 0;
    public static final int MAXIMUM_SCHADEVRIJE_JAREN = 40;
    public static final double KORTING_PER_JAAR = 0.05;
    public static final double MAX_KORTING_PER_JAAR = 0.70;
    public static final double KORTING_START = 1.0;
    public static final double MAX_KORTING = 0.3;
    public static final double CATEGORIE_PERCENTAGE_START = 11.0;
    public static final double DELER = 100.0;

    private Auto auto;
    private int aantalSchadevrijeJaren = 0;


    // Setter met validatie
    public void setAantalSchadevrijeJaren(int aantalSchadevrijeJaren) {
        if (aantalSchadevrijeJaren < MINIMUM_SCHADEVRIJE_JAREN) {
            System.out.println("Het aantal schadevrije jaren moet minimaal 0 zijn!");
        } else if (aantalSchadevrijeJaren > MAXIMUM_SCHADEVRIJE_JAREN) {
            System.out.println("Het aantal schadevrije jaren mag maximaal 40 zijn!");
        } else {
            this.aantalSchadevrijeJaren = aantalSchadevrijeJaren;
        }
    }


    // Constructor
    public AutoPolis(String naamPolishouder, int verzekerdBedrag,
                     LocalDate startDatum, int eigenRisico, Auto auto,
                     int aantalSchadevrijeJaren) {
        super(naamPolishouder, verzekerdBedrag, startDatum, eigenRisico);
        this.auto = auto;
        setAantalSchadevrijeJaren(aantalSchadevrijeJaren);
    }


    // Bereken premie op basis van categorie en schadevrije jaren
    @Override
    public double berekenJaarPremie() {
        double kortingPercentage = KORTING_PER_JAAR * aantalSchadevrijeJaren;
        double korting = kortingPercentage < MAX_KORTING_PER_JAAR
                ? KORTING_START - kortingPercentage
                : MAX_KORTING;

        return getVerzekerdBedrag() *
                ((CATEGORIE_PERCENTAGE_START - (double) eigenRisicoCategorie) /
                        DELER) * korting;
    }

    // Methode voor nieuwe toString
    @Override
    public String toString() {
        return String.format("""
                Polis op naam van %s
                \tVerzekerd bedrag: %d euro
                \tStartdatum: %s
                \tEigen risico categorie: %d
                \tAuto: %s %s met kenteken %s
                \tAantal schadevrije jaren: %d
                \tJaarpremie: %.2f euro""",
                naamPolishouder, verzekerdBedrag, startDatum,
                eigenRisicoCategorie, auto.getMerk(), auto.getKlasse(),
                auto.getKenteken(), aantalSchadevrijeJaren,
                berekenJaarPremie());
    }
}
