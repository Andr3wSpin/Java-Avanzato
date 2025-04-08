
import java.util.Map;

import java.util.Set;
import java.util.stream.Collectors;


public class TestStream {

    public static void main(String[] args) {

        ElencoAgriturismi elencoAgriturismi = ElencoAgriturismi.carica("Agriturismi-Benevento.csv");
<<<<<<< HEAD


=======
>>>>>>> c61b192c3dc466e68126486c3f6492cee5193eca

        System.out.println(elencoAgriturismi);

<<<<<<< HEAD
        //Map<String, Integer> postiXcomune =  elencoAgriturismi.stream().map(Agriturismo ::getComune);
        Set<?> comuni = elencoAgriturismi.stream().map(Agriturismo::getComune).collect(Collectors.toSet());
        System.out.println(comuni.toString());
       // System.out.println(elencoAgriturismi);
=======
        Map<String, Integer> postiXcomune =  elencoAgriturismi.stream().collect( Collectors.groupingBy(
                   Agriturismo::getComune,
                   Collectors.summingInt(Agriturismo::getPostiLetto)
                                                             ));







        System.out.println((elencoAgriturismi.elencoComuni()).toString());
        //System.out.println(elencoAgriturismi);
>>>>>>> 6859eb1b81a40d97b48d1122a1c2a4bfa4f10e53

    }
}
