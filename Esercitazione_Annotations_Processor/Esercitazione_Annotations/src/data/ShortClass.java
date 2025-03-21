package data;

import myannotations.AtMostThree;
import myannotations.FieldNumberConstraint;

@FieldNumberConstraint(value = 1)
@AtMostThree
public class ShortClass {

    private int var;

    public void metodo1(){
        System.out.println("nulla");
    }
}
