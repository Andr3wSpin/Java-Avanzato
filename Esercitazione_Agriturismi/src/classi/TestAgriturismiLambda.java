package classi;

public class TestAgriturismiLambda {

    public static void main(String[] args) {

        ElencoAgriturismi elencoAgriturismi = ElencoAgriturismi.carica("Agriturismi-Napoli.csv");

        //System.out.println(elencoAgriturismi);

        //filtro per tutti i comuni di agerola con piu di 10 posti letto
        ElencoAgriturismi agerola = elencoAgriturismi.filtra(a-> a.getComune().equals("AGEROLA")).filtra(a-> a.getPostiLetto() > 10);
        //System.out.println(agerola);

        //aggiorno il valore pernottamento se impostato a false
        agerola.aggiorna(agriturismo -> agriturismo.isPernottamento());
        System.out.println(agerola);
        agerola.filtra(agriturismo -> agriturismo.isPernottamento() == true);
        //aggirono  il valore isCamping se ci sono posti tenda

        ElencoAgriturismi camping = elencoAgriturismi.filtra( f-> f.getPostiTenda()>0).filtra(f-> f.getPostiRoulotte()>0);
        camping.aggiorna(f-> f.setCamping(true));
        //System.out.println(camping);

       // ElencoAgriturismi agerola = elencoAgriturismi.filtra( a-> a.getComune().equals("AGEROLA"));
        //agerola.aggiorna(a-> a.setPostiLetto(5) );
        //System.out.println(agerola);

       //oridno l elenco in base ai Titolari
        agerola.ordina( (b, a) -> a.getTitolare().compareTo(b.getTitolare()));
     //  System.out.println(agerola);
      //ritorno il numero di posti letto id tutti gli agriturismi di agerola
    //  int somma=  agerola.somma( (a)->  a.getPostiLetto()  );
      //  System.out.println(somma);
    }
}
