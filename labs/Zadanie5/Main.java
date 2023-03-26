package pl.edu.uj.javaframe;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        try{
            FileInputStream fstream = new FileInputStream(args[0]);
            FileOutputStream fout = new FileOutputStream(args[1]);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fout));

            MicroDVD.delay(br, bw, Integer.parseInt(args[2]), Integer.parseInt(args[3]));

            br.close();
            bw.close();

            fstream.close();
            fout.close();
        } catch(IndexOutOfBoundsException e) {
            System.out.println("Niepoprawna liczba argumentów.");
        } catch(NumberFormatException e) {
            System.out.println("Trzeci i czwarty argument powinien być typu int." + '\n' + e);
        } catch(IOException e) {
            System.out.println("Niepoprawna ścieżka do pliku wejściowego lub podany plik nie istnieje");
        } catch(FileException e) {
            System.out.println("Niepoprawna treść pliku wejściowego");
        }
    }
}