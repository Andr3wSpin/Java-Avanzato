import java.util.Map;

public class TestStream {

    public static void main(String[] args) {

        ElencoAgriturismi elencoAgriturismi = ElencoAgriturismi.carica("Agriturismi-Benevento.csv");

        System.out.println(elencoAgriturismi);

        Map<String, Integer> postiXcomune =  elencoAgriturismi.stream().map(Agriturismo ::getComune)





    }
}
