package data;


import annotation.AtMostThree;
import annotation.FieldNumberConstraint;

@FieldNumberConstraint(2)
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