/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processor;

import annotation.FieldNumberConstraint;
import annotation.AtMostThree;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

@SupportedAnnotationTypes({"annotation.AtMostThree","annotation.FieldNumberConstraint"})
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class AtMostThreeProcessor extends AbstractProcessor {

    private Messager messager;

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        // get elements annotated with the @Setter annotation
        Set<? extends Element> AtMostThreeClass = roundEnv.getElementsAnnotatedWith(AtMostThree.class);
        for (Element element : AtMostThreeClass) {
            if (element.getKind() == ElementKind.CLASS) {
                checkAtMostThree((RoundEnvironment) (TypeElement) element);
            }
        }

        // don't claim annotations to allow other processors to process them
        return false;
    }

    private void checkAtMostThree(RoundEnvironment roundEnv) {
        int methodCount = 0;  // Contatore per i metodi annotati

        for (Element element : roundEnv.getElementsAnnotatedWith(AtMostThree.class)) {
            if (element.getKind() == ElementKind.METHOD) {
                methodCount++;  // Incrementa il contatore
            }
        }

        // Se ci sono più di 3 metodi annotati, genera un errore
        if (methodCount > 3) {
            printError(null, "The class has more than 3 methods annotated with @AtMostThree");
        }
    }

    private void printError(Element element, String message) {
        messager.printMessage(Diagnostic.Kind.ERROR, message, element);
    }

    @Override
    public void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);

        // get messager for printing errors
        messager = processingEnvironment.getMessager();
    }

}