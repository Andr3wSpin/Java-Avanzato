package com.mycompany.concurrency.model;

public enum Difficolta {
    
    FACILE(20), MEDIO(15), DIFFICILE(5);
        
    private int tempo;
    
    Difficolta(int tempo) {
    
        this.tempo = tempo;
    }
}
