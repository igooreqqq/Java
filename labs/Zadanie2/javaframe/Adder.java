package pl.edu.uj.javaframe;

public class Adder implements Applayable
{
    private final String toAdd;
    public Adder(String toAdd){
        this.toAdd = toAdd;
    }
    @Override
    public void apply(Series s) {
        for(Value v: s.values){
            Int nv = (Int)new Int().create(toAdd);
        }
    }
}
