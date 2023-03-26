package pl.edu.uj.javaframe;

public class Int extends Value{
    @Override
    public Value create(String val) {
        Int v = new Int();
        v.value = Integer.parseInt(val);
        return v;
    }

    @Override
    public Value add(Value v) {
        Int other = (Int)v;

        Int result  = new Int();
        result.value = (Integer)this.value + (Integer)other.value;

        return result;
    }
}
