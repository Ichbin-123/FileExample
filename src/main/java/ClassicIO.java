import java.io.*;

public class ClassicIO {
    private static final String FILE_NAME = "nuovo_file.txt";

    public static void main(String[] args) {
        scrivereSuFile(FILE_NAME);
        leggereDaFile(FILE_NAME);
    }

    private static void leggereDaFile(String path) {
        File file = new File(path);
        if (!file.exists()) {
            System.err.println("Il file " + path + " non esiste.");
            return;
        }
        try (
                FileReader reader = new FileReader(path);
                BufferedReader buffered = new BufferedReader((reader))
        ) {
            // String riga= "";
            String riga = buffered.readLine();
            while(riga!=null){
                System.out.println(riga);
                riga = buffered.readLine();
            }
        } catch (IOException ioException) {
            System.err.println("ERRORE: " + ioException.getMessage());
        }
    }

    public static void scrivereSuFile(String path) {
        // Try with resources = risorse chiude in automatico
        try (
                FileWriter writer = new FileWriter(path);
                BufferedWriter buffered = new BufferedWriter(writer)
        ) {
            buffered.write("Questa è la prima riga");
            buffered.newLine();
            buffered.write("Seconda riga" + 123);
            buffered.newLine();
            buffered.write("Fine del file.....");
        } catch (IOException ioEx) {
            System.err.println("ERRORE: " + ioEx.getMessage());
        }
    }
}
