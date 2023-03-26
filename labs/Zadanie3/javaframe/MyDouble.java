package pl.edu.uj.javaframe;

public class MyDouble extends Value {
    @Override
    public Value create(String val) {
        MyDouble v = new MyDouble();
        v.value = Double.parseDouble(val);
        return v;
    }

    @Override
    public Value add(Value v) {
        MyDouble result  = new MyDouble();
        result.value = (Double)this.value + Double.valueOf(v.value.toString());

        return result;

    }

    @Override
    public Value sub(Value v) {
        MyDouble result = new MyDouble();
        result.value = (Double)this.value - Double.valueOf(v.value.toString());

        return result;
    }

    @Override
    public Value mul(Value v) {
        MyDouble result = new MyDouble();
        result.value = (Double)this.value * Double.valueOf(v.value.toString());

        return result;
    }

    @Override
    public Value div(Value v) {
        MyDouble result = new MyDouble();
        result.value = (Double)this.value / Double.valueOf(v.value.toString());

        return result;
    }

    @Override
    public Value pow(Value v) {
        MyDouble result = new MyDouble();
        double wynik = 1;

        wynik = Math.pow((Double)this.value, Double.valueOf(v.value.toString()));

        result.value = wynik;

        return result;
    }

    @Override
    public boolean eq(Value v) {
        double a;
        a = (Double)this.value;
        double b;
        b = Double.valueOf(v.value.toString());
        if(a == b)
            return true;

        else
            return false;
    }

    @Override
    public boolean lte(Value v) {
        double a;
        a = (Double)this.value;
        double b;
        b = Double.valueOf(v.value.toString());
        if(a <= b)
            return true;

        else
            return false;
    }

    @Override
    public boolean gte(Value v) {
        double a;
        a = (Double)this.value;
        double b;
        b = Double.valueOf(v.value.toString());
        if(a >= b)
            return true;

        else
            return false;
    }

    @Override
    public boolean neq(Value v) {
        double a;
        a = (Double)this.value;
        double b;
        b = Double.valueOf(v.value.toString());
        if(a != b)
            return true;

        else
            return false;
    }

    @Override
    public boolean equals(Object other) {
        return value.equals(((MyDouble)other).value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
