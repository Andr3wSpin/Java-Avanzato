package classi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ElencoAgriturismi {

  private List<Agriturismo> elenco ;



  public ElencoAgriturismi(){

    elenco = new ArrayList<>();

  }


  public void aggiungi (Agriturismo a){

    elenco.add(a);

  }




  public void esporta(){

  }

  public List<Agriturismo> filtra (Predicate<Agriturismo> filtroAgriturismo){

      List<Agriturismo> agriturismoFiltrato = new ArrayList<>();

       for (Agriturismo a: elenco){

         if (filtroAgriturismo.test(a))  agriturismoFiltrato.add(a);

       }


        return agriturismoFiltrato;
  }


  public void ordina(Comparator<Agriturismo> comparator){

    elenco.sort(comparator);

  }

  public List<Agriturismo> aggiorna(Consumer<Agriturismo> aggiorna){
        List<Agriturismo> agriturismoAggiornato = new ArrayList<>();

        for (Agriturismo a: elenco){



        }

        return agriturismoAggiornato;
  }

  public void somma(){

  }


  public void carica(){



  }

}
