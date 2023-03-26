package pl.pesel;

public class Pesel {

    Pesel(String peselNumber){ //konstruktor
        this.peselNumber = peselNumber;
    }

    String peselNumber;

    public void peselCompare(String peselNumber2){
        if(this.peselNumber.equals(peselNumber2)) {
            System.out.println("Podane pesele są identyczne.");
        }
        else{
            System.out.println("Podane pesele są różne");
        }
    }

    static boolean checkPesel(String peselNumber)
    {
        String[] cyfry =  peselNumber.split("(?<=.)");

        int[] cyfryInt = new int[cyfry.length];

        for(int i = 0; i < cyfry.length; i++) {
            cyfryInt[i] = Integer.parseInt(cyfry[i]);
        }

        if(cyfry.length != 11) {
            System.out.println("Długość numeru PESEL jest nieprawidłowa!");
            return false;
        }

        int[] wagi = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};

        int suma = 0;

        for(int i = 0; i < cyfryInt.length - 1; i++) {
            int iloczyn = wagi[i] * cyfryInt[i];
            suma += iloczyn;
        }

        int c11;

        if(suma % 10 != 0) {
            c11 = 10 - (suma % 10);
        }

        else
            c11 = 0;

        if(cyfryInt[10] == c11) {
            System.out.println("Podany numer PESEL jest prawidlowy!");
            return true;
        }

        else {
            System.out.println("Podany numer PESEL jest nieprawidłowy!");
            return false;
        }
    }
}
