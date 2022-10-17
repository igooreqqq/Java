package pl.edu.uj.kolos;

public abstract class Shape {
    public String name;
    public abstract double calculateSurfaceArea();
    public abstract double calculatePerimeter();
    public abstract String getName();
    public abstract void scale(double scalingFactor) throws ScalingFactorException;
}
