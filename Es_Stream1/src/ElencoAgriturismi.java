import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class ElencoAgriturismi {

  private List<Agriturismo> elenco ;

  public ElencoAgriturismi() {

    elenco = new ArrayList<>();
  }


  public void aggiungi(Agriturismo a) {

    elenco.add(a);
    //ordina();
  }

  public Set<String> esporta(Predicate<Agriturismo> filtroAgriturismo) {

      Set<String> comuni = new HashSet<>();

      for(Agriturismo a : elenco) {

          if(filtroAgriturismo.test(a)) comuni.add(a.getComune());
      }

      return comuni;
  }

  public ElencoAgriturismi filtra (Predicate<Agriturismo> filtroAgriturismo) {

     ElencoAgriturismi e = new ElencoAgriturismi();

       for (Agriturismo a: elenco){

         if (filtroAgriturismo.test(a))  e.elenco.add(a);
       }

        return e;
  }

  public void ordina(Comparator<Agriturismo> comparator) {

      elenco.sort(comparator);

  }

  public void aggiorna(Consumer<Agriturismo> aggiorna) {

        for (Agriturismo a: elenco) aggiorna.accept(a);
  }

  public int somma(Function<Agriturismo,Integer> sommatore){

      int somma=0;

       for (Agriturismo a : elenco){

          somma += sommatore.apply(a);

       }

    return somma;

  }

  public static List<Agriturismo> carica(String nomeFile) {

      Path filePath = Paths.get(nomeFile);

      try(Stream<String> lines = Files.lines(filePath)) {

        return lines.skip(1).map(ElencoAgriturismi::creaAgriturismo).toList();
      } catch (IOException e) {

          return null;
      }
  }

  public static Agriturismo creaAgriturismo(String riga) {

      String[] campi = riga.split(";");

      String comuneAzienda = campi[0];
      String nomeTitolare = campi[1].split(" ")[1];
      String cognomeTitolare = campi[1].split(" ")[0];
      String denominazioneAzienda = campi[2];
      String indirizzoAzienda = campi[3];
      int postiLetto = campi[4].isEmpty() ? 0 : Integer.parseInt(campi[4]);
      int postiMacchina = campi[5].isEmpty() ? 0 : Integer.parseInt(campi[5]);
      int postiTenda = campi[6].isEmpty() ? 0 : Integer.parseInt(campi[6]);
      int postiRoulotte = campi[7].isEmpty() ? 0 : Integer.parseInt(campi[7]);
      String recapiti = campi[8];
      Titolare titolare = new Titolare(nomeTitolare, cognomeTitolare, recapiti);

      return new Agriturismo(comuneAzienda, titolare, denominazioneAzienda,
              indirizzoAzienda, postiLetto, postiMacchina, postiTenda, postiRoulotte);
  }

  @Override
  public String toString() {

      StringBuilder sb = new StringBuilder();

      for(Agriturismo agriturismo : elenco) sb.append(agriturismo + "\n");

      return sb.toString();
  }


    public Stream<Agriturismo> stream(){
        return elenco.stream();
    }



}
