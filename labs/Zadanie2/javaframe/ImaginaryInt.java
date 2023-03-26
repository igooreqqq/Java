package pl.edu.uj.javaframe;

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
    public String toString() {
        return this.value + "i" + this.imaginaryPart;
    }
}
