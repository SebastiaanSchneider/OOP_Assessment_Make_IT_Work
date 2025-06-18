package controller;

import model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Launcherklasse voor het testen van het Verzekeringssysteem.
 */
public class VerzekeringskantoorLauncher {

    public static void main(String[] args) {
        System.out.println("Dit is het assessment gemaakt door Sebastiaan Schneider, studentnummer 500612720\n");

        // Test 1: Lijst van auto's opbouwen
        List<Auto> autoLijst = new ArrayList<>();
        autoLijst.add(new Auto("7-THT-78", "Toyota", "hybrid"));
        autoLijst.add(new Auto("70-HN-KL", "Renault", "benzine"));
        autoLijst.add(new Auto("GP-GL-46", "Mercedes", "diesel"));
        autoLijst.add(new Auto("RX-462-G", "Tesla", "electrisch"));
        autoLijst.add(new Auto("25-ZK-FK", "Dacia", "benzine"));
        autoLijst.add(new Auto("34-XL-KG", "Skoda", "diesel"));
        autoLijst.add(new Auto("56-HFZ-2", "Mitsubishi", "hybrid"));
        autoLijst.add(new Auto("TP-639-X", "Tesla", "electrisch"));
        autoLijst.add(new Auto("ST-857-F", "Renault", "electrisch"));

        // Test 2: Voorbeeld WA_Polis
        Polis testA = new WA_Polis("testa", 50, LocalDate.now(), 2, 1);
        System.out.println("Test 2: WA_Polis aangemaakt:\n" + testA + "\n");

        // Test 3: AutoPolis met negatieve en te hoge schadevrije jaren
        Polis testB = new AutoPolis("testb", 50,
                LocalDate.now(), 2, autoLijst.get(1), -4);
        System.out.println("Test 3: AutoPolis met negatieve schadevrije jaren:\n" + testB + "\n");
        Polis testJ = new AutoPolis("testj", 50,
                LocalDate.now(), 2, autoLijst.get(2), 999);
        System.out.println("Test 12: AutoPolis met schadevrije jaren 999:\n" + testJ + "\n");
        Polis testC = new AutoPolis("testc", 50,
                LocalDate.now(), 2, autoLijst.get(1), 60);
        System.out.println("Test 4: AutoPolis met te hoge schadevrije jaren:\n" + testC + "\n");
        Polis testK = new AutoPolis("testk", 50,
                LocalDate.now(), 2, autoLijst.get(2), -999);
        System.out.println("Test 13: AutoPolis met schadevrije jaren -999:\n" + testK + "\n");

        // Test 4: Verzekeringskantoor met meerdere polissen
        Polis testD = new WA_Polis("testd", 50,
                LocalDate.now(), 2, 1);
        Polis testE = new WA_Polis("teste", 50,
                LocalDate.now(), 2, 1);
        Polis testF = new WA_Polis("testf", 50,
                LocalDate.now(), 2, 1);
        Verzekeringskantoor kantoor = new Verzekeringskantoor("Kantoor Test", "Plaatsnaam");
        kantoor.voegPolisToe(testD);
        kantoor.voegPolisToe(testE);
        kantoor.voegPolisToe(testF);
        System.out.println("Test 5: Polissen toegevoegd aan Verzekeringskantoor.\n");

        // Test 5: Toon auto's van merk 'Dacia'
        System.out.println("Test 6: Toon auto's van merk 'Dacia':");
        toonAutosVanMerk(autoLijst, "Dacia");
        System.out.println();

        // Test 6: AutoPolis met geldige max schadevrije jaren
        Polis testG = new AutoPolis("testg", 50,
                LocalDate.now(), 2, autoLijst.getFirst(), 50);
        System.out.println("Test 7: AutoPolis met max geldige schadevrije jaren:\n" + testG + "\n");

        // Test 7: AutoPolis met null auto
        try {
            Polis testH = new AutoPolis("testh", 50,
                    LocalDate.now(), 2, null, 10);
            System.out.println("Test 8: AutoPolis met null auto:\n" + testH + "\n");
        } catch (Exception e) {
            System.out.println("Test 8: Exception bij aanmaken AutoPolis met null auto: " + e.getMessage() + "\n");
        }

        // Test 8: Polis met negatieve looptijd
        try {
            Polis testI = new WA_Polis("testi", 50,
                    LocalDate.now(), -3, 1);
            System.out.println("Test 9: Polis met negatieve looptijd:\n" + testI + "\n");
        } catch (Exception e) {
            System.out.println("Test 9: Exception bij aanmaken polis met negatieve looptijd: " + e.getMessage() + "\n");
        }

        // Test 9: Zoek auto's van niet-bestaand merk
        System.out.println("Test 10: Zoek auto's van niet-bestaand merk 'Lada':");
        toonAutosVanMerk(autoLijst, "Lada");
        System.out.println();
    }

    /**
     * Drukt alle auto's van een specifiek merk af.
     */
    public static void toonAutosVanMerk(List<Auto> autoLijst, String merk) {
        boolean gevonden = false;
        for (Auto auto : autoLijst) {
            if (auto.getMerk().equals(merk)) {
                System.out.println(auto);
                gevonden = true;
            }
        }
        if (!gevonden) {
            System.out.println("Geen auto's gevonden van merk '" + merk + "'.");
        }
    }
}
