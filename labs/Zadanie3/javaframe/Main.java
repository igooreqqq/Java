package pl.edu.uj.javaframe;

import java.io.IOException;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {

        DataFrame df = new DataFrame(new Class[] {Int.class, Int.class}, new String[] {"kol1","kol2"});

        df.addRow(new String[]{"12","23"});
        df.addRow(new String[]{"1244","23"}); df.addRow(new String[]{"1244","2553"});
        df.addRow(new String[]{"12","2300"});

        ImaginaryInt imaginaryInt = new ImaginaryInt();
        ImaginaryInt imaginaryInt2 = new ImaginaryInt();

        Int Int = new Int();
        Int int1 = new Int();

        MyDouble myDouble = new MyDouble();
        MyDouble myDouble2 = new MyDouble();

        ImaginaryDouble imaginaryDouble = new ImaginaryDouble();
        ImaginaryDouble imaginaryDouble2 = new ImaginaryDouble();


        System.out.println("--------------------------------------------------------");

        System.out.println("(Int) Operacja add: " + Int.create("10").add(int1.create("5")));
        System.out.println("(Int) Operacja sub: " + Int.create("10").sub(int1.create("5")));
        System.out.println("(Int) Operacja mul: " + Int.create("10").mul(int1.create("5")));
        System.out.println("(Int) Operacja div: " + Int.create("10").div(int1.create("5")));
        System.out.println("(Int) Operacja pow: " + Int.create("10").pow(int1.create("5")));
        System.out.println("(Int) Operacja eq: " + Int.create("10").eq(int1.create("10")));
        System.out.println("(Int) Operacja lte: " + Int.create("10").lte(int1.create("11")));
        System.out.println("(Int) Operacja gte: " + Int.create("12").gte(int1.create("11")));
        System.out.println("(Int) Operacja neq: " + Int.create("10").neq(int1.create("10")));
        System.out.println("(Int) Operacja equals: " + Int.create("10").equals(int1.create("10")));

        System.out.println("--------------------------------------------------------");

        System.out.println("(myDouble) Operacja add: " + myDouble.create("10").add(myDouble2.create("5")));
        System.out.println("(myDouble) Operacja sub: " + myDouble.create("10").sub(myDouble2.create("5")));
        System.out.println("(myDouble) Operacja mul: " + myDouble.create("10").mul(myDouble2.create("5")));
        System.out.println("(myDouble) Operacja div: " + myDouble.create("10").div(myDouble2.create("5")));
        System.out.println("(myDouble) Operacja pow: " + myDouble.create("10").pow(myDouble2.create("5")));
        System.out.println("(myDouble) Operacja eq: " + myDouble.create("10").eq(myDouble2.create("10")));
        System.out.println("(myDouble) Operacja lte: " + myDouble.create("10").lte(myDouble2.create("11")));
        System.out.println("(myDouble) Operacja gte: " + myDouble.create("10").gte(myDouble2.create("5")));
        System.out.println("(myDouble) Operacja neq: " + myDouble.create("10").neq(myDouble2.create("5")));
        System.out.println("(myDouble) Operacja equals: " + myDouble.create("10").equals(myDouble2.create("10")));

        System.out.println("--------------------------------------------------------");

        System.out.println("(ImaginaryInt) Operacja add: " + imaginaryInt.create("10i5").add(imaginaryInt2.create("2i3")));
        System.out.println("(ImaginaryInt) Operacja sub: " + imaginaryInt.create("10i5").sub(imaginaryInt2.create("2i3")));
        System.out.println("(ImaginaryInt) Operacja mul: " + imaginaryInt.create("-5i4").mul(imaginaryInt2.create("-8i-2")));
        System.out.println("(ImaginaryInt) Operacja div: " + imaginaryInt.create("1i8").div(imaginaryInt2.create("2i3")));
        System.out.println("(ImaginaryInt) Operacja pow: " + imaginaryInt.create("-10i6").pow(Int.create("2")));
        System.out.println("(ImaginaryInt) Operacja eq: " + imaginaryInt.create("10i5").eq(imaginaryInt2.create("10i5")));
        System.out.println("(ImaginaryInt) Operacja lte: " + imaginaryInt.create("8i8").lte(imaginaryInt2.create("9i7")));
        System.out.println("(ImaginaryInt) Operacja gte: " + imaginaryInt.create("11i5").gte(imaginaryInt2.create("10i6")));
        System.out.println("(ImaginaryInt) Operacja neq: " + imaginaryInt.create("10i5").neq(imaginaryInt2.create("10i5")));
        System.out.println("(ImaginaryInt) Operacja equals: " + imaginaryInt.create("10i5").equals(imaginaryInt2.create("10i5")));

        System.out.println("--------------------------------------------------------");

        System.out.println("(ImaginaryDouble) Operacja add: " + imaginaryDouble.create("10i5").add(imaginaryDouble2.create("2i3")));
        System.out.println("(ImaginaryDouble) Operacja sub: " + imaginaryDouble.create("10i5").sub(imaginaryDouble2.create("2i3")));
        System.out.println("(ImaginaryDouble) Operacja mul: " + imaginaryDouble.create("10i5").mul(imaginaryDouble2.create("2i3")));
        System.out.println("(ImaginaryDouble) Operacja div: " + imaginaryDouble.create("10.25i-4").div(imaginaryDouble2.create("2.5i-1.5")));
        System.out.println("(ImaginaryDouble) Operacja pow: " + imaginaryDouble.create("10i6.25").pow(myDouble.create("2.55")));
        System.out.println("(ImaginaryDouble) Operacja eq: " + imaginaryDouble.create("10i5").eq(imaginaryDouble2.create("10i5")));
        System.out.println("(ImaginaryDouble) Operacja lte: " + imaginaryDouble.create("7i8").lte(imaginaryDouble2.create("8i7")));
        System.out.println("(ImaginaryDouble) Operacja gte: " + imaginaryDouble.create("12i1").gte(imaginaryDouble2.create("10i2")));
        System.out.println("(ImaginaryDouble) Operacja neq: " + imaginaryDouble.create("9i5").neq(imaginaryDouble2.create("10i5")));
        System.out.println("(ImaginaryDouble) Operacja equals: " + imaginaryDouble.create("10i5").equals(imaginaryDouble2.create("10i5")));



//      INSTRUKCJE DO ĆWICZEŃ I

//      Dopisz metodę print w klasie DataFrame wypisującą zawartość dataframe
//      df.print();

//      Dodaj klasę ImaginaryDouble oraz ImaginaryInt, które dziedziczą po odpowiednio klasach Int i Double . Powinne one być tworzone ze Stringów postaci "<CzęśćRzeczywissta>i<CzęśćUrojona>", np "12i3".

//      Nadpisz metody create i add w klasach ImaginaryDoubgle oraz ImaginaryInt. Pamiętaj, że do liczb urojonych możemy też dodawać inne typy (np. Int, Double).
//      Przetestuj wyniki operacji:
            //        ImaginaryInt.create("12i4").add(Int.create("10"))
            //        Int.create("10").add(ImaginaryInt.create("12i4")))
            //        ImaginaryInt.create("12i4").add(ImaginaryInt.create("10i10"))

//      Nadpisz metodę public String toString() w kasach ImaginaryDouble i ImaginaryInt, tak aby poprawnie wyświetlała liczby urojone do postaci Stringa



    }
}
