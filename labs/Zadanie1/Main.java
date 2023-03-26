package pl.pesel;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Podaj numer PESEL do sprawdzenia: ");

        Scanner scanner = new Scanner(System.in);
        String podajPesel;
        podajPesel = scanner.next();

        Pesel pesel = new Pesel(podajPesel);
        Pesel pesel2 = new Pesel("55030101193");

        System.out.println("Podany numer PESEL to: " + pesel.peselNumber);

        Pesel.checkPesel(pesel.peselNumber);

        pesel.peselCompare(pesel2.peselNumber);
    }
}