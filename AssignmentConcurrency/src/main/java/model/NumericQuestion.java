
package model;

public class NumericQuestion {
    
    private int num1;
    private int num2;
    private Operator operator;
    private int result;
    
    public NumericQuestion(int num1, int num2, Operator operator, int expectedAnswer) {
        
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
    }
    
    public int getResult() {
        
        return result;
    }
    
    
}
