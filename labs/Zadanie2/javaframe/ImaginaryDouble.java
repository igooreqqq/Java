package pl.edu.uj.javaframe;

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
    public String toString() {
        return this.value + "i" + this.imaginaryPart;
    }
}
