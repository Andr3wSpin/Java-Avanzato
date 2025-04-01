package classi;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ElencoAgriturismi {

  private Set<Agriturismo> elenco ;



  public ElencoAgriturismi(){

    elenco = new TreeSet<>();

  }


  public void aggiungi (Agriturismo a){

    elenco.add(a);

  }




  public void esporta(){

  }

  public ElencoAgriturismi filtra (Predicate<Agriturismo> filtroAgriturismo){

     ElencoAgriturismi e = new ElencoAgriturismi();

       for (Agriturismo a: elenco){

         if (filtroAgriturismo.test(a))  e.elenco.add(a);

       }


        return e;
  }


  public void ordina(Comparator<Agriturismo> comparator){



  }

  public ElencoAgriturismi aggiorna(Agriturismo b ,Consumer<Agriturismo> aggiorna){

    ElencoAgriturismi e = new ElencoAgriturismi();

        for (Agriturismo a: elenco){

         if(a.equals(b))  {

           aggiorna.accept(a);

         }

        }

        return e;
  }

  public void somma(){

  }


  public void carica(){



  }

}
