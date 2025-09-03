import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileClassExample {
    public static void main(String[] args) {
        // Creaimo un oggetto
        File mioFile = new File("mio_file.txt");

        if(mioFile !=null) // non controllo così l'esistenza del file.....
            System.out.println("mio_file.txt");

        // Controllare se il file esiste. Co^si controllo l'esistenza del file
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

        // Info sui file
        if(mioFile.exists()){
            System.out.println("\n Nome: " + mioFile.getName());
            System.out.println("Percorso: " + mioFile.getAbsolutePath());
            System.out.println("Directory?: " + mioFile.isDirectory());
            System.out.println("File?: " + mioFile.isFile());
            System.out.println("Dimensioni: " + mioFile.length());
            System.out.println("Ultima modifica: " + new Date(mioFile.lastModified()));
        }

        // Crea una Directory
        File miaDirectory = new File("mia_directory");
        boolean created = miaDirectory.mkdir();
        if(created) System.out.println("Directory " + miaDirectory.getName() + " creata con successo");
        else System.out.println("Directory " + miaDirectory.getName() + " gia presente");

    }
}
