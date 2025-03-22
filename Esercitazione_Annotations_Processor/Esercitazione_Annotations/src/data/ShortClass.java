package data;

import annotation.AtMostThree;
import annotation.FieldNumberConstraint;

@FieldNumberConstraint(1)
@AtMostThree
public class ShortClass {

    private int var;

    public void metodo1(){
        System.out.println("nulla");
    }
}
