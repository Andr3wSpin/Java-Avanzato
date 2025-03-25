package annotation.processor;

import annotation.AtMostThree;

import java.util.List;
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
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

@SupportedAnnotationTypes({"annotation.AtMostThree"})
@SupportedSourceVersion(SourceVersion.RELEASE_23)
public class AtMostThreeProcessor extends AbstractProcessor {

    private Messager messager;

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        Set<? extends Element> AtMostThreeClass = roundEnv.getElementsAnnotatedWith(AtMostThree.class);

        for (Element element : AtMostThreeClass) {
            if (element.getKind() == ElementKind.CLASS) {
                checkAtMostThree((TypeElement) element);
            }
        }

        return false;
    }

    private void checkAtMostThree(TypeElement classe) {

        int methodCount = 0;

        for (Element element : classe.getEnclosedElements()) {
            if (element.getKind() == ElementKind.METHOD) {
                methodCount++;
            }
        }

        if (methodCount > 3) {
            printError(classe, "La classe " + classe.getSimpleName() + " ha più di 3 metodi.");
        }
    }

    private void printError(Element element, String message) {
        messager.printMessage(Diagnostic.Kind.ERROR, message, element);
    }

    @Override
    public void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);

        messager = processingEnvironment.getMessager();
    }

}