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

    @Override
    public Value sub(Value v) {
        Int other = (Int)v;

        Int result = new Int();
        result.value = (Integer)this.value - (Integer)other.value;

        return result;
    }

    @Override
    public Value mul(Value v) {
        Int other = (Int)v;

        Int result = new Int();
        result.value = (Integer)this.value * (Integer)other.value;

        return result;
    }

    @Override
    public Value div(Value v) {
        Int other = (Int)v;

        Int result = new Int();
        result.value = (Integer)this.value / (Integer)other.value;

        return result;
    }

    @Override
    public Value pow(Value v) {
        Int other = (Int)v;
        int wynik = 1;

        Int result = new Int();
        for(int i = 0; i < (Integer)other.value; i++) {
            wynik *= (Integer)this.value;
        }

        result.value = wynik;

        return result;
    }

    @Override
    public boolean eq(Value v) {
        Int other = (Int)v;

        if(this.value == other.value)
            return true;

        else
            return false;
    }

    @Override
    public boolean lte(Value v) {
        Int other = (Int)v;

        if((Integer)this.value <= (Integer)other.value)
            return true;

        else
            return false;
    }

    @Override
    public boolean gte(Value v) {
        Int other = (Int)v;

        if((Integer)this.value >= (Integer)other.value)
            return true;

        else
            return false;
    }

    @Override
    public boolean neq(Value v) {
        Int other = (Int)v;

        if(this.value != other.value)
            return true;

        else
            return false;
    }

    @Override
    public boolean equals(Object other) {
        return value.equals(((Int)other).value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
