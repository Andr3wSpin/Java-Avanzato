package com.mycompany.concurrency.model;

public enum Operazione {
   
    SOMMA('+'), SOTTRAZIONE('-'), MOLTIPLICAZIONE('*');
    
    private char segno;
    
    Operazione(char segno) {
        
        this.segno = segno;
    }
    
    public char getSegno() {
        
        return segno;
    }
}
