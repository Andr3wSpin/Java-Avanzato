package com.mycompany.concurrency.model;



import java.util.ArrayList;
import java.util.Random;
import java.util.List;

/**
 *
 * @author Utente
 */
public class Partita {
    //gestione partita
    private final String nome;
    private Difficolta difficolta;
    private final int numero_Domande=10;
    private  List <Domanda> questions;
   
    
    
    public Partita(String nome,Difficolta f){
    
        this.nome=nome;
        this.difficolta=f;
        questions = new ArrayList<>();
        initQuestion();
    }
    
    public void initQuestion(){
        Random random = new Random();
        for(int i = 0; i<numero_Domande; i++){
            int n1 = random.nextInt(100)+1;
            int n2 = random.nextInt(100)+1;
            int sign = random.nextInt(3);
            switch(sign){
                case 0:
                    questions.add(new Domanda(n1,n2,Operazione.SOMMA));
                break;
                case 1:
                    questions.add(new Domanda(n1,n2,Operazione.SOTTRAZIONE));
                break;
                case 2:
                    questions.add(new Domanda(n1,n2,Operazione.MOLTIPLICAZIONE));
                break;
            }
           
        }
    }

    public List<Domanda> getQuestions() {
        return questions;
    }
    
    
}
