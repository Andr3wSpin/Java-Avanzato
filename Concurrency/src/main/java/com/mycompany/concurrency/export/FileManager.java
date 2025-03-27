package com.mycompany.concurrency.export;

import com.mycompany.concurrency.model.Domanda;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FileManager {
    
   public static void esportaFile(File file, List<Domanda> esito) {
       
       try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)))) {
           
           pw.println("DOMANDA;RISULTATO CORRETTO;ESITO");
           
          for(Domanda domanda : esito) {
              
              pw.append(domanda + ";");
              pw.append(domanda.getRisultato() + ";");
              
              if(domanda.isCorrect()) pw.append("Risposta corretta.\n");
              else pw.append("Risposta errata.\n");
          }
       } catch(IOException e) {
           
           System.out.println(e.getMessage());
       }
   }
}
