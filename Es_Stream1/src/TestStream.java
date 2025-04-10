import java.util.*;
import java.util.stream.Collectors;

public class TestStream {

    public static void main(String[] args) {

        List<Agriturismo> elenco = ElencoAgriturismi.carica("Agriturismi-Benevento.csv");

//        System.out.println("Lista agriturismi:");
//        stampaCollection(elenco);

        List<Agriturismo> elencoOrdinato = elenco.stream().sorted(
                (a,b) -> a.getDenominazione().compareTo(b.getDenominazione())).toList();

        System.out.println("Elenco ordinato afabeticamente:");
     //   stampaCollection(elencoOrdinato);

        Set<String> comuni = elenco.stream().map(Agriturismo::getComune).collect(Collectors.toSet());
//        System.out.println("Lista dei comuni che ospitanto agriturismi:");
//        stampaCollection(comuni);
       // System.out.println(elencoAgriturismi);

        //indicare il comune con piu posti campeggio



        Map<String, Integer> postiXcomune =  elenco.stream().collect( Collectors.groupingBy(
                   Agriturismo::getComune,
                   Collectors.summingInt(Agriturismo::getPostiLetto)
                                                             ));

        //aggironi i valori del campeggio

       List<Agriturismo> campeggi =       elenco.stream().filter(  f ->  f.getPostiRoulotte()>0 || f.getPostiTenda()>0 ).map( agriturismo -> {
                agriturismo.setCamping(true);
                    return agriturismo;   }).collect(Collectors.toList());


        //System.out.println(campeggi);

              //aggiorno pernottamneto

        List<Agriturismo> elencoAggiornato  =       elenco.stream().filter(  f ->  f.getPostiLetto()>0 ).map( agriturismo -> {
            agriturismo.setPernottamento(true);
            return agriturismo;   }).collect(Collectors.toList());
        //System.out.println(elencoAggiornato);
    }

    private static void stampaCollection(Collection<?> collezione) {

        StringBuilder sb = new StringBuilder();

        for(Object elemento : collezione) sb.append(elemento + "\n");

        System.out.println(sb);
    }
}
