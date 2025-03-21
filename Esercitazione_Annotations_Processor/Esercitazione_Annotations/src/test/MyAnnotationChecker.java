package test;

import data.*;
import exceptions.AnnotationException;
import myannotations.AtMostThree;
import myannotations.FieldNumberConstraint;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MyAnnotationChecker {

    public static void main(String[] args) {

        //Class<?> classe = LongClass.class;
        Class<?> classe = ShortClass.class;

        try {

            verify_class(classe);
        } catch (AnnotationException e) {

            System.err.println(e.getMessage());
        }
    }

    public static void verify_class(Class<?> classe) throws AnnotationException {

        AtMostThree amt = null;
        FieldNumberConstraint fnc = null;

        if((amt = classe.getAnnotation(AtMostThree.class)) != null) {

            Method[] metodi = classe.getDeclaredMethods();

            if(metodi.length > 3)
                throw new AnnotationException("La classe '" + classe.getSimpleName() + "' " +
                        "ha più di 3 metodi.");

            System.out.println("La classe '" + classe.getSimpleName() +
                    "' rispetta i vincoli di AtMostThree.");
        }

        if((fnc = classe.getAnnotation(FieldNumberConstraint.class)) != null) {

            Field[] fields = classe.getDeclaredFields();

            if(fields.length != fnc.value())
                throw new AnnotationException("La classe '" + classe.getSimpleName() + "' " +
                        "deve avere esattamente " + fnc.value() + " variabili d'istanza.");

            System.out.println("La classe '" + classe.getSimpleName() +
                    "' rispetta i vincoli di FieldNumberChecker.");
        }
    }
}
