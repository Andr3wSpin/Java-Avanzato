package classi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

  public void filtra (Predicate p){


  }


  public void ordina(){


  }

  public void aggiorna(){

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
