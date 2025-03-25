/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package model;

/**
 *
 * @author paolo
 */
public enum Difficulty {
    FACILE(20),MEDIO(15),DIFFICILE(5);
    private int time;
    private Difficulty(int time){
        this.time = time;
    }

    public int getTime(){
        return this.time;
    }
}
