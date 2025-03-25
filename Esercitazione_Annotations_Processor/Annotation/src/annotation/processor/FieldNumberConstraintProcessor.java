package annotation.processor;

import annotation.FieldNumberConstraint;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;

@SupportedAnnotationTypes("annotation.FieldNumberConstraint")
@SupportedSourceVersion(SourceVersion.RELEASE_23)
public class FieldNumberConstraintProcessor extends AbstractProcessor {

    private Messager messager;

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        Set<? extends Element> elementiAnnotati = roundEnv.getElementsAnnotatedWith(FieldNumberConstraint.class);

        for(Element elemento : elementiAnnotati) {

            if(elemento.getKind() == ElementKind.CLASS) {

                verificaClasse((TypeElement) elemento);
            }
        }

        return false;
    }

    private void verificaClasse(TypeElement classe) {

        FieldNumberConstraint fnc = classe.getAnnotation(FieldNumberConstraint.class);

         int fieldCount = 0;

         for(Element elemento : classe.getEnclosedElements()) {

             if(elemento.getKind() == ElementKind.FIELD)

                 fieldCount++;
         }

         if(fieldCount != fnc.value())

             stampaErrore(classe, "La classe " + classe.getSimpleName() + " ha più di " + fnc.value() + " attributi");
    }

    private void stampaErrore(Element classe, String messaggio) {

        messager.printMessage(Diagnostic.Kind.ERROR, messaggio, classe);
    }

    @Override
    public void init(ProcessingEnvironment processingEnvironment) {

        super.init(processingEnvironment);

        messager = processingEnvironment.getMessager();
    }
}