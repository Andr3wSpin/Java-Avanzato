import java.util.Set;
import java.util.stream.Collectors;

public class TestStream {

    public static void main(String[] args) {

        ElencoAgriturismi elencoAgriturismi = ElencoAgriturismi.carica("Agriturismi-Benevento.csv");
        System.out.println((elencoAgriturismi.elencoComuni()).toString());
        //System.out.println(elencoAgriturismi);
    }
}
