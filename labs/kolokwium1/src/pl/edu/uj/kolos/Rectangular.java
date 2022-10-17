package pl.edu.uj.kolos;

public class Rectangular extends Shape{
    private double x, y, dlugosc, szerokosc;

    public Rectangular(double x, double y, double dlugosc, double szerokosc) {
        name = "Rectangular";
        this.x = x;
        this.y = y;
        this.dlugosc = dlugosc;
        this.szerokosc = szerokosc;
    }

    public double calculateSurfaceArea(){
        double surfaceArea;
        surfaceArea = dlugosc * szerokosc;

        return surfaceArea;
    }

    public double calculatePerimeter(){
        double perimeter;
        perimeter = (2 * dlugosc) + (2 * szerokosc);

        return perimeter;
    }

    public String getName(){
        return name;
    }

    public void scale(double scalingFactor) throws ScalingFactorException{
        dlugosc = scalingFactor * dlugosc;
        szerokosc = scalingFactor * szerokosc;
        //return new Rectangular(x, y, scalingFactor * dlugosc, scalingFactor * szerokosc);
    }
}
