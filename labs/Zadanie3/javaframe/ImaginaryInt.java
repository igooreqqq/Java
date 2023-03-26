package pl.edu.uj.javaframe;

import java.util.Objects;
import java.lang.Math;

public class ImaginaryInt extends Int{
    Int imaginaryPart;

    @Override
    public Value create(String val) {
        String[] reim = val.split("i");
        this.value = super.create(reim[0]).value;
        if(reim.length == 2) {
            imaginaryPart = (Int) new Int().create(reim[1]);
        } else {
            imaginaryPart = (Int) new Int().create("0");
        }
        return this;
    }

    @Override
    public Value add(Value v) {
        ImaginaryInt result = new ImaginaryInt();
        ImaginaryInt otherIm = (ImaginaryInt) new ImaginaryInt().create(v.toString());
        result.value = (Integer)this.value + Integer.valueOf(v.value.toString());
        result.imaginaryPart = (Int) imaginaryPart.add(otherIm.imaginaryPart);

        return result;
    }

    @Override
    public Value sub(Value v) {
        ImaginaryInt result = new ImaginaryInt();
        ImaginaryInt otherIm = (ImaginaryInt) new ImaginaryInt().create(v.toString());
        result.value = (Integer)this.value - Integer.valueOf(v.value.toString());
        result.imaginaryPart = (Int) imaginaryPart.sub(otherIm.imaginaryPart);

        return result;
    }

    @Override
    public Value mul(Value v) {
        ImaginaryInt result = new ImaginaryInt();
        ImaginaryInt otherIm = (ImaginaryInt) new ImaginaryInt().create(v.toString());
        result.value = (Integer)this.value * Integer.valueOf(v.value.toString()) - Integer.valueOf(this.imaginaryPart.toString()) * Integer.valueOf(otherIm.imaginaryPart.toString());
        result.imaginaryPart = (Int) super.create(Integer.toString((int) ((Integer)this.value * Integer.valueOf(otherIm.imaginaryPart.toString()) + Integer.valueOf(v.value.toString()) * Integer.valueOf(this.imaginaryPart.toString()))));

        return result;
    }

    @Override
    public Value div(Value v) {
        ImaginaryInt result = new ImaginaryInt();
        ImaginaryInt otherIm = (ImaginaryInt) new ImaginaryInt().create(v.toString());
        result.value = (Integer)this.value * Integer.valueOf(v.value.toString()) - Integer.valueOf(this.imaginaryPart.toString()) * (-Integer.valueOf(otherIm.imaginaryPart.toString()));
        result.imaginaryPart = (Int) super.create(Integer.toString((int) ((Integer)this.value * (-Integer.valueOf(otherIm.imaginaryPart.toString())) + Integer.valueOf(v.value.toString()) * Integer.valueOf(this.imaginaryPart.toString()))));

        double mianownik;
        mianownik = Math.pow(Integer.valueOf(v.value.toString()), 2) + Math.pow(Integer.valueOf(otherIm.imaginaryPart.toString()), 2);
        result.value = (int) ((Integer)result.value / mianownik);
        result.imaginaryPart =  (Int) super.create(Integer.toString((int) (Integer.valueOf(result.imaginaryPart.toString()) / mianownik)));
        return result;
    }

    @Override
    public Value pow(Value v) {
        ImaginaryInt result = new ImaginaryInt();
        ImaginaryInt otherIm = (ImaginaryInt) new ImaginaryInt().create(v.toString());

        double modul = (Integer) this.value * (Integer) this.value + Integer.valueOf(this.imaginaryPart.toString()) * Integer.valueOf(this.imaginaryPart.toString());
        modul = Math.sqrt(modul);
        double modulPow;
        modulPow = Math.pow(modul, (Integer) v.value);

        double kat;
        kat = Math.atan(Double.valueOf(this.imaginaryPart.toString()) / (Integer) this.value);
        result.value = (int) (Math.cos((Integer) v.value * kat) * modulPow);
        result.imaginaryPart = (Int) super.create(Integer.toString((int) (Math.sin(Integer.valueOf(otherIm.value.toString()) * kat) * modulPow)));
        return result;
    }

    @Override
    public boolean eq(Value v) {
        ImaginaryInt otherIm = (ImaginaryInt) new ImaginaryInt().create(v.toString());
        if(super.eq(v) && imaginaryPart.eq(otherIm.imaginaryPart))
            return true;

        else
            return false;
    }

    @Override
    public boolean lte(Value v) {
        ImaginaryInt result = new ImaginaryInt();
        ImaginaryInt otherIm = (ImaginaryInt) new ImaginaryInt().create(v.toString());
        result.value = this.value;
        if((Integer)this.value < Integer.valueOf(v.value.toString()))
            return true;
        else if(this.value == Integer.valueOf(v.value.toString())) {
            if(imaginaryPart.lte(otherIm.imaginaryPart))
                return true;
            return false;
        }
        else
            return false;
    }

    @Override
    public boolean gte(Value v) {
        ImaginaryInt result = new ImaginaryInt();
        ImaginaryInt otherIm = (ImaginaryInt) new ImaginaryInt().create(v.toString());
        result.value = this.value;
        if((Integer)this.value > Integer.valueOf(v.value.toString()))
            return true;
        else if(this.value == Integer.valueOf(v.value.toString())) {
            if(imaginaryPart.gte(otherIm.imaginaryPart))
                return true;
            return false;
        }
        else
            return false;
    }

    @Override
    public boolean neq(Value v) {
        ImaginaryInt otherIm = (ImaginaryInt) new ImaginaryInt().create(v.toString());
        if(super.neq(v) || imaginaryPart.neq(otherIm.imaginaryPart))
            return true;

        else
            return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ImaginaryInt that = (ImaginaryInt) o;
        return Objects.equals(imaginaryPart, that.imaginaryPart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), imaginaryPart);
    }

    @Override
    public String toString() {
        return this.value + "i" + this.imaginaryPart;
    }
}
