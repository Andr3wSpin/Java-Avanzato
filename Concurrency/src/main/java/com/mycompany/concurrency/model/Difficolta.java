package com.mycompany.concurrency.model;

public enum Difficolta {
    
    FACILE(20), MEDIO(15), DIFFICILE(10);
        
    private int tempo;
    
    Difficolta(int tempo) {
    
        this.tempo = tempo;
    }
    
    public int getTempo() { return tempo; }
}
