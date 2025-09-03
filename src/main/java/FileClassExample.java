import java.io.File;
import java.io.IOException;

public class FileClassExample {
    public static void main(String[] args) {
        // Creaimo un oggetto
        File mioFile = new File("mio_file.txt");

        if(mioFile !=null)
            System.out.println("mio_file.txt");

        // Controllare se il file esiste
        System.out.println(
                "Il file esiste? " + mioFile.exists()
        );

        // Creaimo effettivamente il file
        try {
            boolean created = mioFile.createNewFile();
            if(created) System.out.println("I file è stato creato con successo");
            else System.out.println("Il file esiste già");
        }
        catch (IOException ioEx){
            System.err.println("ERRORE: " + ioEx.getMessage());
        }

        // Di nuovo check se file esiste
        System.out.println(
                "Il file esiste? " + mioFile.exists()
        );

    }
}
