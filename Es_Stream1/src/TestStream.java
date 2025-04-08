
import java.util.Map;

import java.util.Set;
import java.util.stream.Collectors;


public class TestStream {

    public static void main(String[] args) {

        ElencoAgriturismi elencoAgriturismi = ElencoAgriturismi.carica("Agriturismi-Benevento.csv");
<<<<<<< HEAD
=======


        System.out.println(elencoAgriturismi);

        Map<String, Integer> postiXcomune =  elencoAgriturismi.stream().map(Agriturismo ::getComune);






>>>>>>> dc5b81b9e13bfbac8d54b8fe557e28a1f88e5150
        System.out.println((elencoAgriturismi.elencoComuni()).toString());
        //System.out.println(elencoAgriturismi);

    }
}
