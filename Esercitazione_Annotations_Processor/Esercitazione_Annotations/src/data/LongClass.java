package data;

import myannotations.AtMostThree;
import myannotations.FieldNumberConstraint;

@FieldNumberConstraint(value = 5)
@AtMostThree
public class LongClass {

    public String var1;
    public int var2;

    public void metodo1(){
        System.out.println("nulla");
    }

    public void metodo2(){
        System.out.println("nulla");
    }

    public void metodo3(){
        System.out.println("nulla");
    }

    public void metodo4(){
        System.out.println("nulla");
    }
}