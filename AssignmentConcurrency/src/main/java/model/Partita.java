package model;

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
    private Difficulty difficolta;
    private final int numero_Domande=10;
    List <NumericQuestion> questions;
    
    
    public Partita(String nome,Difficulty f){
    
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
                    questions.add(new NumericQuestion(n1,n2,Operator.ADD));
                break;
                case 1:
                    questions.add(new NumericQuestion(n1,n2,Operator.SUB));
                break;
                case 2:
                    questions.add(new NumericQuestion(n1,n2,Operator.MUL));
                break;
            }
           
        }
    }
    
    
}
