<<<<<<< HEAD
import java.util.Map;
=======
import java.util.Set;
import java.util.stream.Collectors;
>>>>>>> fee5debdc294095a44071f5376a2d82e693506be

public class TestStream {

    public static void main(String[] args) {

        ElencoAgriturismi elencoAgriturismi = ElencoAgriturismi.carica("Agriturismi-Benevento.csv");

<<<<<<< HEAD
        System.out.println(elencoAgriturismi);

        Map<String, Integer> postiXcomune =  elencoAgriturismi.stream().map(Agriturismo ::getComune)





=======
        System.out.println((elencoAgriturismi.elencoComuni()).toString());
        //System.out.println(elencoAgriturismi);
>>>>>>> fee5debdc294095a44071f5376a2d82e693506be
    }
}
