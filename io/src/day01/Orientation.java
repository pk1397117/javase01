package day01;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class Orientation implements Serializable {

    private static final long serialVersionUID = -7988178957967007531L;
    public static final Orientation HORIZONTAL = new Orientation(1);
    public static final Orientation VERTICAL = new Orientation(2);
    private int value;
    private Orientation(int value){
        this.value = value;
    }

    protected Object readResolve() throws ObjectStreamException {
        if (value == 1) return HORIZONTAL;
        if (value == 2) return VERTICAL;
        throw new ObjectStreamException(){};
    }
}
