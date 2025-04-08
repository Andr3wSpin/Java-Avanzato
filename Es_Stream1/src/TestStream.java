
import java.util.Map;

import java.util.Set;
import java.util.stream.Collectors;


public class TestStream {

    public static void main(String[] args) {

        ElencoAgriturismi elencoAgriturismi = ElencoAgriturismi.carica("Agriturismi-Benevento.csv");


        System.out.println(elencoAgriturismi);


        //Map<String, Integer> postiXcomune =  elencoAgriturismi.stream().map(Agriturismo ::getComune);
        Set<?> comuni = elencoAgriturismi.stream().map(Agriturismo::getComune).collect(Collectors.toSet());
        System.out.println(comuni.toString());
       // System.out.println(elencoAgriturismi);

        Map<String, Integer> postiXcomune =  elencoAgriturismi.stream().collect( Collectors.groupingBy(
                   Agriturismo::getComune,
                   Collectors.summingInt(Agriturismo::getPostiLetto)
                                                             ));

    }
}
