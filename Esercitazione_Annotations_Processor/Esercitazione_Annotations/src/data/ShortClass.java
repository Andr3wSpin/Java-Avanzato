package data;

import annotation.AtMostThree;
import annotation.FieldNumberConstraint;



@FieldNumberConstraint()
@AtMostThree
public class ShortClass {

    private int var;

    public void metodo1(){
        System.out.println("nulla");
    }
}
