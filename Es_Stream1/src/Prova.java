import java.util.List;
import java.util.stream.Stream;

public class Prova {

    public static void main(String[] args) {

        List<Agriturismo> elenco = ElencoAgriturismi.carica("Agriturimi-Benevento.csv");

        System.out.println(elenco);
    }
}
