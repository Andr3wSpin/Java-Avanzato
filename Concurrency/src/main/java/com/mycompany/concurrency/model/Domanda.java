package com.mycompany.concurrency.model;

public class Domanda {
    
    private int num1, num2;
    private Operazione operazione;
    private int risultato;
    private int risposta;
    
    public Domanda(int num1, int num2, Operazione operazione) {
        
        this.num1 = num1;
        this.num2 = num2;
        this.operazione = operazione;
        
        calcolaRisultato();
    }

    private void calcolaRisultato() {
       
        switch(operazione) {
            
            case SOMMA:
                risultato = num1 + num2;
                break;
            case SOTTRAZIONE: 
                risultato = num1 - num2;
                break;
            case MOLTIPLICAZIONE: 
                risultato = num1 * num2;
                break;
        }
    }
    
    public void setRisposta(int risposta) { this.risposta = risposta; }
    
    public int getRisposta() { return risposta; }
    
    public int getRisultato() { return risultato; }
    
    
    @Override
    public String toString() {
        
        return num1 + " " + num2 + " " + operazione.getSegno() + " = ";
    }
}
