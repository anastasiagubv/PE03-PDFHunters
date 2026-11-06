package cat.escolapia;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;

/**
 * Classe encarregada de comprovar si una contrasenya obre un document PDF protegit.
 */
public class PDFChecker {

    /**
     * Comprova si la contrasenya indicada permet obrir el document PDF.
     *
     * @param rutaPdf  ruta del fitxer PDF protegit
     * @param password contrasenya a provar
     * @return true si la contrasenya és correcta, false en cas contrari
     */
    public static boolean comprovarPassword(String rutaPdf, String password) {
        try (PDDocument document = Loader.loadPDF(new File(rutaPdf), password)) {
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
