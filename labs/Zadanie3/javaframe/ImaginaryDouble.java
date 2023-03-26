package pl.edu.uj.javaframe;

import java.util.Objects;

public class ImaginaryDouble extends MyDouble{
    MyDouble imaginaryPart;

    @Override
    public Value create(String val) {
        String[] reim = val.split("i");
        this.value = super.create(reim[0]).value;
        if(reim.length == 2) {
            imaginaryPart = (MyDouble) new MyDouble().create(reim[1]);
        }
        else {
            imaginaryPart = (MyDouble) new MyDouble().create("0");
        }
        return this;
    }

    @Override
    public Value add(Value v) {
        ImaginaryDouble result  = new ImaginaryDouble();
        ImaginaryDouble otherIm = (ImaginaryDouble) new ImaginaryDouble().create(v.toString());
        result.value = (Double)this.value + Double.valueOf(v.value.toString());
        result.imaginaryPart = (MyDouble) imaginaryPart.add(otherIm.imaginaryPart);

        return result;
    }


    @Override
    public Value sub(Value v) {
        ImaginaryDouble result = new ImaginaryDouble();
        ImaginaryDouble otherIm = (ImaginaryDouble) new ImaginaryDouble().create(v.toString());
        result.value = (Double)this.value - Double.valueOf(v.value.toString());
        result.imaginaryPart = (MyDouble) imaginaryPart.sub(otherIm.imaginaryPart);

        return result;
    }

    @Override
    public Value mul(Value v) {
        ImaginaryDouble result = new ImaginaryDouble();
        ImaginaryDouble otherIm = (ImaginaryDouble) new ImaginaryDouble().create(v.toString());
        result.value = (Double)this.value * Double.valueOf(v.value.toString()) - Double.valueOf(this.imaginaryPart.toString()) * Double.valueOf(otherIm.imaginaryPart.toString());
        result.imaginaryPart = (MyDouble) super.create(Double.toString((double) ((Double)this.value * Double.valueOf(otherIm.imaginaryPart.toString()) + Double.valueOf(v.value.toString()) * Double.valueOf(this.imaginaryPart.toString()))));

        return result;
    }

    @Override
    public Value div(Value v) {
        ImaginaryDouble result = new ImaginaryDouble();
        ImaginaryDouble otherIm = (ImaginaryDouble) new ImaginaryDouble().create(v.toString());
        result.value = (Double)this.value * Double.valueOf(v.value.toString()) - Double.valueOf(this.imaginaryPart.toString()) * (-Double.valueOf(otherIm.imaginaryPart.toString()));
        result.imaginaryPart = (MyDouble) super.create(Double.toString((double) ((Double)this.value * (-Double.valueOf(otherIm.imaginaryPart.toString())) + Double.valueOf(v.value.toString()) * Double.valueOf(this.imaginaryPart.toString()))));

        double mianownik;
        mianownik = Math.pow(Double.valueOf(v.value.toString()), 2) + Math.pow(Double.valueOf(otherIm.imaginaryPart.toString()), 2);
        result.value = ((Double)result.value / mianownik);
        result.imaginaryPart =  (MyDouble) super.create(Double.toString( (Double.valueOf(result.imaginaryPart.toString()) / mianownik)));
        return result;
    }

    @Override
    public Value pow(Value v) {
        ImaginaryDouble result = new ImaginaryDouble();
        ImaginaryDouble otherIm = (ImaginaryDouble) new ImaginaryDouble().create(v.toString());

        double modul = (Double) this.value * (Double) this.value + Double.valueOf(this.imaginaryPart.toString()) * Double.valueOf(this.imaginaryPart.toString());
        modul = Math.sqrt(modul);
        double modulResult;

        modulResult = Math.pow(modul, (Double) v.value);

        double kat;
        kat = Math.atan(Double.valueOf(this.imaginaryPart.toString()) / (Double) this.value);
        result.value = Math.cos((Double) v.value * kat) * modulResult;
        result.imaginaryPart = (MyDouble) super.create(Double.toString( (Math.sin(Double.valueOf(otherIm.value.toString()) * kat) * modulResult)));
        return result;
    }

    @Override
    public boolean eq(Value v) {
        ImaginaryDouble otherIm = (ImaginaryDouble) new ImaginaryDouble().create(v.toString());
        if(super.eq(v) && imaginaryPart.eq(otherIm.imaginaryPart))
            return true;

        else
            return false;
    }

    @Override
    public boolean lte(Value v) {
        ImaginaryDouble otherIm = (ImaginaryDouble) new ImaginaryDouble().create(v.toString());

        double a = (Double)this.value;
        double b = Double.valueOf(v.value.toString());
        if(a < b)
            return true;
        else if(a == b) {
            if(imaginaryPart.lte(otherIm.imaginaryPart))
                return true;
            return false;
        }
        else
            return false;
    }

    @Override
    public boolean gte(Value v) {
        ImaginaryDouble otherIm = (ImaginaryDouble) new ImaginaryDouble().create(v.toString());

        double a = (Double)this.value;
        double b = Double.valueOf(v.value.toString());
        if(a > b)
            return true;
        else if(a == b) {
            if(imaginaryPart.gte(otherIm.imaginaryPart))
                return true;
            return false;
        }
        else
            return false;
    }

    @Override
    public boolean neq(Value v) {
        ImaginaryDouble otherIm = (ImaginaryDouble) new ImaginaryDouble().create(v.toString());
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
        ImaginaryDouble that = (ImaginaryDouble) o;
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