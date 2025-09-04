import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FunctionalIO {

    private static final String NOME_FILE = "file_funzionale.txt";
    public static void main(String[] args) {

        Path path = Paths.get(NOME_FILE);

        List<String> listaStringhe = Arrays.asList(
                "Questa è la prima riga",
                "Madonna quanto è bello Java",
                "La versione italiana di 'Hello World' in Java",
                "Basta"
        );

        scrivereSuFile(path, listaStringhe);
        leggereDaFile(path);
        processareFile(path);
    }

    private static void processareFile(Path path) {
        try(Stream<String> streamDiRighe = Files.lines(path)){
            streamDiRighe
                    .filter(riga -> riga.contains("Java"))
                    .map(String::toUpperCase) // s->s.toLowerCase()
                    .forEach(riga -> System.out.println(riga)); // System.out::println
        } catch (IOException ioEx){
            System.err.println("ERRORE: " + ioEx.getMessage());
        }
    }

    private static void leggereDaFile(Path path){
        try {
            List<String> listaRighe = Files.readAllLines(path);
            listaRighe.stream()
                    .forEach(riga -> System.out.println("> "+ riga));
        }  catch (IOException ioEx) {
            System.err.println("ERRORE: " + ioEx.getMessage());
        }
    }

    private static void scrivereSuFile(Path path, List<String> listaStringhe){
        try {
            Files.write(path, listaStringhe);
        } catch (IOException ioEx) {
            System.err.println("ERRORE: " + ioEx.getMessage());
        }
    }
}
