package pl.edu.uj.javaframe;

public class FileException extends Exception{

    public FileException(String in_text_line, int line) {
        System.out.println("Błąd zawartości: " + in_text_line + '\n' + "w linijce pliku wejściowego nr: " + line);
    }

    public FileException() {
        System.out.println("Wartość końcowa klatki początkowej lub klatki końcowej jest ujemna.");
    }
}
