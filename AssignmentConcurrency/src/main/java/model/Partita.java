/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Utente
 */
public class Partita {
    //gestione partita
    private String Nome;
    private Difficulty difficolta;
    private final int numero_Domande=10;
    
    
    public Partita(String nome,Difficulty f){
    
        this.Nome=nome;
        this.difficolta=f;
    }
    
    
}
