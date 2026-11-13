package cat.escolapia;

import java.util.Scanner;

public class Main {

    private static final String PDF_MISSION1 = "src/main/resources/documents/01_caixa_forta.pdf";
    private static final String PDF_MISSION2 = "src/main/resources/documents/02_projecte_secret.pdf";
    private static final String PDF_MISSION3 = "src/main/resources/documents/03_contrasenya_director.pdf";
    private static final String PDF_MISSION4 = "src/main/resources/documents/04_arxiu_ultrasecret.pdf";
    private static final String DICTIONARY_PATH = "src/main/resources/diccionari.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            showMenu();
            option = readOption(scanner);

            // GUIA FETA AMB IA
            switch (option) {
                case 1:
                    // Missió 1 - PIN BREAKER
                    // Resultat result1 = BruteForce.pinBreaker(PDF_MISSION1);
                    // showResult(result1);
                    // Statistics.add(result1);
                    System.out.println("Missió 1 encara no implementada.");
                    break;
                case 2:
                    // Missió 2 - ALPHANUMERIC HUNTER
                    // Resultat result2 = BruteForce.alphanumericHunter(PDF_MISSION2);
                    // showResult(result2);
                    // Statistics.add(result2);
                    System.out.println("Missió 2 encara no implementada.");
                    break;
                case 3:
                    // Missió 3 - DICTIONARY ATTACK
                    // Resultat result3 = DictionaryAttack.dictionaryAttack(PDF_MISSION3, DICTIONARY_PATH);
                    // showResult(result3);
                    // Statistics.add(result3);
                    System.out.println("Missió 3 encara no implementada.");
                    break;
                case 4:
                    // Missió 4 - FINAL BOSS
                    // Resultat result4 = PasswordVariants.finalBoss(PDF_MISSION4, DICTIONARY_PATH);
                    // showResult(result4);
                    // Statistics.add(result4);
                    System.out.println("Missió 4 encara no implementada.");
                    break;
                case 5:
                    // Estadístiques
                    // Statistics.showComparison();
                    System.out.println("Estadístiques encara no implementades.");
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

    private static void showResult(Resultat result) {
        System.out.println();
        System.out.println("----------------------------------");
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
        System.out.println();
    }
}
