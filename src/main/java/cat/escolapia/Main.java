package cat.escolapia;

import java.util.Scanner;

/**
 * PDF HUNTERS - Operació Força Bruta
 * Pràctica Entregable 03 - Programació de Serveis i Processos (DAM2)
 * Grup 4
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcio;

        do {
            mostrarMenu();
            opcio = llegirOpcio(scanner);

            switch (opcio) {
                case 1:
                    // TODO: Missió 1 - PIN BREAKER
                    System.out.println("Missió 1 encara no implementada.");
                    break;
                case 2:
                    // TODO: Missió 2 - ALPHANUMERIC HUNTER
                    System.out.println("Missió 2 encara no implementada.");
                    break;
                case 3:
                    // TODO: Missió 3 - DICTIONARY ATTACK
                    System.out.println("Missió 3 encara no implementada.");
                    break;
                case 4:
                    // TODO: Missió 4 - FINAL BOSS
                    System.out.println("Missió 4 encara no implementada.");
                    break;
                case 5:
                    // TODO: Estadístiques
                    System.out.println("Estadístiques encara no implementades.");
                    break;
                case 0:
                    System.out.println("Fins aviat!");
                    break;
                default:
                    System.out.println("Opció no vàlida.");
            }
        } while (opcio != 0);

        scanner.close();
    }

    private static void mostrarMenu() {
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

    private static int llegirOpcio(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
