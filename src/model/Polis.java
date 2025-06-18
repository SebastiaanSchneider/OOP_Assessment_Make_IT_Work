package model;

import java.time.LocalDate;

/**
 * Abstracte klasse voor polissen.
 * Bevat gemeenschappelijke eigenschappen van WA- en Autopolissen.
 */
public abstract class Polis implements Comparable<Polis> {
    public static final int STANDAARD_CATEGORIE = 1;
    public static final int MIN_CATEGORIE = 1;
    public static final int MAX_CATEGORIE = 3;
    protected String naamPolishouder;
    protected int verzekerdBedrag;
    protected LocalDate startDatum;
    protected int eigenRisicoCategorie;


    // Getter
    public int getVerzekerdBedrag() {
        return verzekerdBedrag;
    }

    // Setter met validatie voor eigen risico
    public void setEigenRisicoCategorie(int eigenRisicoCategorie) {
        if (eigenRisicoCategorie >= MIN_CATEGORIE && eigenRisicoCategorie <=
                MAX_CATEGORIE) {
            this.eigenRisicoCategorie = eigenRisicoCategorie;
        } else {
            System.out.println("Eigen risico categorie moet 1, 2 of 3 zijn. Het is nu ingesteld op de standaardcategorie 1.");
            this.eigenRisicoCategorie = STANDAARD_CATEGORIE;
        }
    }


    // Constructor
    public Polis(String naamPolishouder, int verzekerdBedrag,
                 LocalDate startDatum, int eigenRisico) {
        this.naamPolishouder = naamPolishouder;
        this.verzekerdBedrag = verzekerdBedrag;
        this.startDatum = startDatum;
        setEigenRisicoCategorie(eigenRisico);
    }


    // Abstracte methode voor het berekenen van de jaarpremie
    public abstract double berekenJaarPremie();

    // Sorteert op startdatum
    @Override
    public int compareTo(Polis anderePolis) {
        return this.startDatum.compareTo(anderePolis.startDatum);
    }

    @Override
    public String toString() {
        return String.format("""
                Polis op naam van %s
                \tVerzekerd bedrag: %d euro
                \tStartdatum: %s
                \tEigen risico categorie: %d""",
                naamPolishouder, verzekerdBedrag, startDatum,
                eigenRisicoCategorie);
    }
}
