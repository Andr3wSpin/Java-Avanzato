import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Prova {

    public static void main(String[] args) {

        List<Agriturismo> elenco = ElencoAgriturismi.carica("Agriturimi-Benevento.csv");

        System.out.println(elenco);

          Map<String,Double> postiCamping = elenco.stream().filter( f-> (f.isCamping()== true) ).collect(Collectors.groupingBy(
                      Agriturismo::getComune, Collectors.averagingInt(Agriturismo::getPostiCamping))

                                         );


        Optional<String> ComuneMaxPosti =  elenco.stream().filter(f-> f.isCamping()==true ).reduce((agriturismo, agriturismo2) ->
                agriturismo.getPostiCamping()>agriturismo2.getPostiCamping() ? agriturismo : agriturismo2
                                                 ).map(Agriturismo::getComune);




    }
}
