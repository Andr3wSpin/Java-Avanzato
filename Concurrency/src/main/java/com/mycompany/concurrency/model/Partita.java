package com.mycompany.concurrency.model;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class Partita {
    //gestione partita
    private final String nome;
    private Difficolta difficolta;
    private final int NUMERO_DOMANDE = 10;
    private  List<Domanda> domande;
   
    public Partita(String nome,Difficolta difficolta){
    
        this.nome = nome;
        this.difficolta = difficolta;
        domande = new ArrayList<>();
        creaDomande();
    }
    
    public void creaDomande(){
        
        Random random = new Random();
        
        for(int i = 0; i < NUMERO_DOMANDE; i++){
            
            int n1 = random.nextInt(100) + 1;
            int n2 = random.nextInt(100) + 1;
            int sign = random.nextInt(3);
            switch(sign){
                case 0:
                    domande.add(new Domanda(n1,n2,Operazione.SOMMA));
                    break;
                case 1:
                    domande.add(new Domanda(n1,n2,Operazione.SOTTRAZIONE));
                    break;
                case 2:
                    domande.add(new Domanda(n1,n2,Operazione.MOLTIPLICAZIONE));
                    break;
            }
        }
    }

    public List<Domanda> getDomande() {
        return domande;
    }
}
