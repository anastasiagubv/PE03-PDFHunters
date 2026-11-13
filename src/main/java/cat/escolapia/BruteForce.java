package cat.escolapia;

// Missió 1 - generar totes les combinacions de 4 dígits (0000-9999)

// Missió 2 - generar combinacions segons el patró C?NNNN

public class BruteForce {

    public static Resultat pinBreaker(String pdfPath) {
        long attempts = 0;
        long startTime = System.nanoTime();
        double timeSeconds = 0;
        String missionName = "Pin Breaker";
        String foundPassword = null;

        for (int i = 0; i <= 9999; i++) {
            String password = String.format("%04d", i);
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
}
