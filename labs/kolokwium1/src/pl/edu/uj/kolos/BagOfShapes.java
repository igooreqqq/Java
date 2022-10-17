package pl.edu.uj.kolos;

import java.util.ArrayList;
import java.util.List;

public class BagOfShapes extends Shape{
    List<Shape> lista = new ArrayList<>();

    public double calculateSurfaceArea(){
        double surfaceArea = 0;
        for(Shape shape : lista){
            surfaceArea += shape.calculateSurfaceArea();
        }
        return surfaceArea;
    }

    public double calculatePerimeter(){
        double perimeter = 0;
        for(Shape shape : lista){
            perimeter += shape.calculatePerimeter();
        }
        return perimeter;
    }

    public String getName(){
        return name;
    }

    public void scale(double scalingFactor) throws ScalingFactorException{
        if(scalingFactor < 0){
            throw new ScalingFactorException("Wartość mniejsza od 0");
        } else{
            for(Shape shape : lista){
                shape.scale(scalingFactor);
            }
        }

    }
}
