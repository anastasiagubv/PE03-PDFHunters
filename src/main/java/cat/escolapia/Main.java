package cat.escolapia;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    private static final String PDF_MISSION1 = "src/main/resources/documents/01_caixa_forta.pdf";
    private static final String PDF_MISSION2 = "src/main/resources/documents/02_projecte_secret.pdf";
    private static final String PDF_MISSION3 = "src/main/resources/documents/03_contrasenya_director.pdf";
    private static final String PDF_MISSION4 = "src/main/resources/documents/04_arxiu_ultrasecret.pdf";
    private static final String DICTIONARY_PATH = "src/main/resources/diccionari.txt";

    // Guarda el resultat de cada missió executada, per a la comparativa final
    private static List<Resultat> results = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            showMenu();
            option = readOption(scanner);

            switch (option) {
                case 1:
                    Resultat result1 = pinBreaker(PDF_MISSION1);
                    showResult(result1);
                    results.add(result1);
                    break;
                case 2:
                    System.out.println("Missió 2 encara no implementada.");
                    break;
                case 3:
                    System.out.println("Missió 3 encara no implementada.");
                    break;
                case 4:
                    System.out.println("Missió 4 encara no implementada.");
                    break;
                case 5:
                    showComparison();
                    break;
                case 0:
                    System.out.println("Fins aviat!");
                    break;
                default:
                    System.out.println("Opció no vàlida.");
            }
        } while (option != 0);

        scanner.close();
    }

    // MENU

    private static void showMenu() {
        System.out.println("========================================");
        System.out.println("               PDF HUNTERS");
        System.out.println("           OPERACIÓ FORÇA BRUTA");
        System.out.println("========================================");
        System.out.println();
        System.out.println("  1. PIN BREAKER");
        System.out.println("  2. ALPHANUMERIC HUNTER");
        System.out.println("  3. DICTIONARY ATTACK");
        System.out.println("  4. FINAL BOSS");
        System.out.println("  5. ESTADÍSTIQUES");
        System.out.println("  0. SORTIR");
        System.out.println();
        System.out.println("========================================");
        System.out.print("Selecciona una missió: ");
    }

    private static int readOption(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    //  MISSIÓ 1 - PIN BREAKER 
    // Genera totes les combinacions de 4 dígits (0000-9999) i les prova

    public static Resultat pinBreaker(String pdfPath) {
        long attempts = 0;
        long startTime = System.nanoTime();
        double timeSeconds = 0;
        String missionName = "Pin Breaker";
        String foundPassword = null;

        ArrayList<String> combinations = new ArrayList<>();
        
        for (int i = 0; i <= 9999; i++) {
            combinations.add(String.format("%04d", i));
        }

        for (int i = 0; i < combinations.size(); i++) {
            String password = combinations.get(i);
            attempts++;

            if (PDFChecker.checkPassword(pdfPath, password)) {
                foundPassword = password;
                break;
            }
        }
        long endTime = System.nanoTime();
        timeSeconds = (endTime - startTime) / 1_000_000_000.0;
 
        Resultat r1 = new Resultat(missionName, foundPassword, attempts, timeSeconds);
        return r1;
    }

    // MISSIÓ 2 - 

    //  SORTIDA DE RESULTATS 

    private static void showResult(Resultat result) {
        System.out.println("\n----------------------------------");
        if (result.isFound()) {
            System.out.println("PASSWORD FOUND!");
            System.out.println("----------------------------------");
            System.out.println("Contrasenya: " + result.getFoundPassword());
        } else {
            System.out.println("CONTRASENYA NO TROBADA");
            System.out.println("----------------------------------");
        }
        System.out.println("Intents: " + result.getAttempts());
        System.out.printf("Temps: %.3f segons%n", result.getTimeSeconds());
        System.out.printf("Velocitat: %.2f intents/s%n", result.getSpeed());
    }

    //  ESTADÍSTIQUES 

    private static void showComparison() {
        if (results.isEmpty()) {
            System.out.println("Encara no s'ha executat cap missió.");
            return;
        }

        System.out.println("\n=========================== COMPARATIVA ===========================");
        System.out.printf("%-25s %-10s %-10s %-12s %-10s%n", "Missió", "Trobada", "Intents", "Temps (s)", "Intents/s");
        System.out.println("-------------------------------------------------------------------");

        for (int i = 0; i < results.size(); i++) {
            Resultat result = results.get(i);

            String found;
            if (result.isFound()) {
                found = "Sí";
            } else {
                found = "No";
            }

            System.out.printf("%-25s %-10s %-10d %-12.3f %-10.2f%n",
                    result.getMissionName(),
                    found,
                    result.getAttempts(),
                    result.getTimeSeconds(),
                    result.getSpeed());
        }
        System.out.println("===================================================================");
    }
}
