/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package model;

/**
 *
 * @author paolo
 */
public enum Operator {
    ADD('+'),SUB('-'),MUL('*');
    
    private char sign;
    
    private Operator(char sign){
        this.sign = sign;
    }
    
    public char getSign(){
        return sign;
    }
}
