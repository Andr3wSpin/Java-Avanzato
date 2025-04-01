package classi;


import java.util.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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

  public void aggiorna(Agriturismo b ,Consumer<Agriturismo> aggiorna){



        for (Agriturismo a: elenco){

         if(a.equals(b))  {

           aggiorna.accept(a);


         }

        }


  }

  public void somma(){

  }


  public static ElencoAgriturismi carica(String nomeFile){

      ElencoAgriturismi elencoAgriturismi = new ElencoAgriturismi();


      try(BufferedReader br = new BufferedReader(new FileReader(nomeFile))) {

          String line = br.readLine();

          while((line = br.readLine()) != null) {

              String[] campi = line.split(";");

              String comuneAzienda = campi[0];
              String titolare = campi[1];
              String denominazioneAzienda = campi[2];
              String indirizzoAzienda = campi[3];
              int postiLetto = campi[4].isEmpty() ? 0 : Integer.parseInt(campi[4]);
              int postiMacchina = campi[5].isEmpty() ? 0 : Integer.parseInt(campi[5]);
              int postiTenda = campi[6].isEmpty() ? 0 : Integer.parseInt(campi[6]);
              int postiRoulotte = campi[7].isEmpty() ? 0 : Integer.parseInt(campi[7]);
              String recapiti = campi[8];

              elencoAgriturismi.aggiungi(new Agriturismo(comuneAzienda, titolare, denominazioneAzienda,
                      indirizzoAzienda, postiLetto, postiMacchina, postiTenda, postiRoulotte, recapiti));
          }

          return elencoAgriturismi;
      } catch(IOException e) {

          return null;
      }

  }

  @Override
  public String toString() {

      StringBuilder sb = new StringBuilder();

      for(Agriturismo agriturismo : elenco) sb.append(agriturismo + "\n");

      return sb.toString();
  }
}
