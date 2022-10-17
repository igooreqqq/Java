package pl.edu.uj.kolos;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ScalingFactorException {
	    BagOfShapes bagOfShapes = new BagOfShapes();
        boolean petla = true;
        while(petla) {
            System.out.println("Wybierz jedną z opcji od 1 do 8");
            System.out.println("1. Dodaj kwadrat");
            System.out.println("2. Dodaj okrąg");
            System.out.println("3. Wyświetl pole powierzchni");
            System.out.println("4. Wyświetl obwód");
            System.out.println("5. Skaluj obiekty");
            System.out.println("6. Print names.");
            System.out.println("7. Remove object of index.");
            System.out.println("8. Exit.");

            Scanner scanner =new Scanner(System.in);
            int i = scanner.nextInt();

            switch(i) {
                case 1:
                    System.out.println("Podaj współrzędne: ");
                    double x_rec = scanner.nextDouble();
                    double y_rec = scanner.nextDouble();
                    double dlugosc_rec = scanner.nextDouble();
                    double szerokosc_rec = scanner.nextDouble();

                    bagOfShapes.lista.add(new Rectangular(x_rec, y_rec, dlugosc_rec, szerokosc_rec));
                    System.out.printf("Dodano do listy Rectangular o wspolrzednych: x=%f, y=%f, dlugosc=%f, szerokosc=%f\n", x_rec, y_rec, dlugosc_rec, szerokosc_rec);
                    break;

                case 2:
                    System.out.println("Podaj współrzędne: ");
                    double x_cir = scanner.nextDouble();
                    double y_cir = scanner.nextDouble();
                    double r_cir = scanner.nextDouble();

                    bagOfShapes.lista.add(new Circle(x_cir, y_cir, r_cir));
                    System.out.printf("Dodano do listy Circle o wspolrzednych: x=%f, y=%f, r=%f\n", x_cir, y_cir, r_cir);
                    break;

                case 3:
                    System.out.printf("Suma pól powierzchni wynosi: %f\n", bagOfShapes.calculateSurfaceArea());
                    break;

                case 4:
                    System.out.printf("Suma obwodów wynosi: %f", bagOfShapes.calculatePerimeter());
                    break;

                case 5:
                    double scale = scanner.nextDouble();
                    bagOfShapes.scale(scale);
                    break;

                case 6:
                    for(Shape shape : bagOfShapes.lista){
                        System.out.println(shape.name);
                    }
                    break;

                case 7:
                    System.out.println("Podaj index elementu ktorego chcesz usunąć");
                    int index = scanner.nextInt();
                    bagOfShapes.lista.remove(index);
                    break;

                case 8:
                    System.exit(0);

                default:
                    System.out.println("Podałeś złą opcję!");
                    break;
            }
        }
    }
}
