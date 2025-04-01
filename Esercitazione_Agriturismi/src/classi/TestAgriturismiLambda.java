package classi;

public class TestAgriturismiLambda {

    public static void main(String[] args) {

        ElencoAgriturismi elencoAgriturismi = ElencoAgriturismi.carica("Agriturismi-Napoli.csv");

       //System.out.println(elencoAgriturismi);


        //filtro per tutti i comuni di agerola con piu di 10 posti letto
        ElencoAgriturismi agerola = elencoAgriturismi.filtra(a-> a.getComune().equals("AGEROLA")).filtra(a-> a.getPostiLetto()>10);
       // System.out.println(agerola);

        //aggiorno tutti gli agriturisimi di agerola a 12 posti letto test aggiorna
       // ElencoAgriturismi agerola = elencoAgriturismi.filtra( a-> a.getComune().equals("AGEROLA"));
        //agerola.aggiorna(a-> a.setPostiLetto(5) );
        //System.out.println(agerola);

       //oridno l elenco in base ai posti autpo disponibili in ordine decrescente

       // agerola.ordina( (b, a) -> Integer.compare(a.getPostiMacchina(),b.getPostiMacchina()));
       // System.out.println(agerola);
      //ritorno il numero di posti letto idi tutti gli agriturismi di agerola
      int somma=  agerola.somma( (a)->  a.getPostiLetto()  );
        System.out.println(somma);


    }
}
