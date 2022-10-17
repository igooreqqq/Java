package pl.edu.uj.kolos;

public class Circle extends Shape{
    private double x, y, r;

    public Circle(double x, double y, double r) {
        name = "Circle";
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public double calculateSurfaceArea(){
        double surfaceArea;
        surfaceArea = Math.PI * Math.pow(r, 2);

        return surfaceArea;
    }

    public double calculatePerimeter(){
        double perimeter;
        perimeter = 2 * Math.PI * r;

        return perimeter;
    }

    public String getName(){
        return name;
    }

    public void scale(double scalingFactor) throws ScalingFactorException{
        r = scalingFactor * r;
    }
}
