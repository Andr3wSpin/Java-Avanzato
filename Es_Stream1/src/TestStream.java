import java.util.*;
import java.util.stream.Collectors;

public class TestStream {

    public static void main(String[] args) {

        List<Agriturismo> elenco = ElencoAgriturismi.carica("Agriturismi-Benevento.csv");

//        System.out.println("Lista agriturismi:");
//        stampaCollection(elenco);
        //ordinare alfabeticamnete



        //aggiorna il valore campeggio

        List<Agriturismo> campeggi =       elenco.stream().filter(  f ->  f.getPostiRoulotte()>0 || f.getPostiTenda()>0 ).map( agriturismo -> {
            agriturismo.setCamping(true);
            return agriturismo;   }).collect(Collectors.toList());


        //System.out.println(campeggi);

        //aggiorno pernottamneto

        List<Agriturismo> aggiornaPernottamento  =  elenco.stream().filter(  f ->  f.getPostiLetto()>0 ).map( agriturismo -> {
            agriturismo.setPernottamento(true);
            return agriturismo;   }).collect(Collectors.toList());
        //System.out.println(elencoAggiornato);



        List<Agriturismo> elencoOrdinato = elenco.stream().sorted(
                (a,b) -> a.getDenominazione().compareTo(b.getDenominazione())).toList();

      //  System.out.println("Elenco ordinato afabeticamente:");
     //   stampaCollection(elencoOrdinato);

        //ottenere il comune con max posti camping
        Optional<String> ComuneMaxPosti =  campeggi.stream().filter(f-> f.isCamping()==true ).reduce((agriturismo, agriturismo2) ->
                agriturismo.getPostiCamping()>agriturismo2.getPostiCamping() ? agriturismo : agriturismo2
        ).map(Agriturismo::getComune);

       // System.out.println(ComuneMaxPosti.get());

        //mappa comune e numero posti letto
        Map<String, Integer> postiXcomune =  elenco.stream().collect( Collectors.groupingBy(
                Agriturismo::getComune,
                Collectors.summingInt(Agriturismo::getPostiLetto)
        ));

      //  System.out.println(postiXcomune);
        // crea una mappa nome Comune numeroPosti camping
        Map<String,Double> postiCamping = campeggi.stream().collect(Collectors.groupingBy(
                Agriturismo::getComune, Collectors.averagingInt(Agriturismo::getPostiCamping))

        );

        //lista comuni che ospitano agriturisimi
        Set<String> comuni = elenco.stream().map(Agriturismo::getComune).collect(Collectors.toSet());
//        System.out.println("Lista dei comuni che ospitanto agriturismi:");
//        stampaCollection(comuni);
       // System.out.println(elencoAgriturismi);


    }

    private static void stampaCollection(Collection<?> collezione) {

        StringBuilder sb = new StringBuilder();

        for(Object elemento : collezione) sb.append(elemento + "\n");

        System.out.println(sb);
    }
}
