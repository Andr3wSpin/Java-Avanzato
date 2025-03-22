package annotation.processor;

import annotation.FieldNumberConstraint;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.List;


@SupportedAnnotationTypes("annotation.FieldNumberConstraint")
@SupportedSourceVersion(SourceVersion.RELEASE_23)
public class FieldNumberConstraintProcessor extends AbstractProcessor {

    private Messager messager;
    private Element elementUnits;
    private Types typeUtils;



    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getElementsAnnotatedWith(FieldNumberConstraint.class)) {
            if (element.getKind() != ElementKind.CLASS) {
                messager.printMessage(Diagnostic.Kind.ERROR, "@FieldNumberConstraint può essere usata solo su classi!", element);

            }

            // Ottieni il valore specificato nell'annotazione
            FieldNumberConstraint annotation = element.getAnnotation(FieldNumberConstraint.class);
            int expectedFieldCount = annotation.value();

            // Conta le variabili d'istanza
            List<VariableElement> fields = element.getEnclosedElements().stream()
                    .filter(e -> e.getKind() == ElementKind.FIELD)
                    .map(e -> (VariableElement) e)
                    .collect(Collectors.toList());

            int actualFieldCount = fields.size();

            // Controlla se il numero di campi è corretto
            if (actualFieldCount != expectedFieldCount) {
                messager.printMessage(
                        Diagnostic.Kind.ERROR,
                        "La classe " + element.getSimpleName() + " ha " + actualFieldCount +
                                " campi, ma ne sono richiesti esattamente " + expectedFieldCount + ".",
                        element
                );
            }
        }
        return true; // Indica che l'annotazione è stata elaborata
    }
}