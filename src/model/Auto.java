package model;

/**
 * Klasse voor het representeren van een auto.
 */
public class Auto {
    private String kenteken;
    private String merk;
    private String klasse;


    // Getters
    public String getKenteken() {
        return kenteken;
    }

    public String getMerk() {
        return merk;
    }

    public String getKlasse() {
        return klasse;
    }


    // Constructor
    public Auto(String kenteken, String merk, String klasse) {
        this.kenteken = kenteken;
        this.merk = merk;
        this.klasse = klasse;
    }


    // Methode voor nieuwe toString
    @Override
    public String toString() {
        return String.format("Auto: kenteken %s, merk %s, klasse %s",
                kenteken, merk, klasse);
    }
}
