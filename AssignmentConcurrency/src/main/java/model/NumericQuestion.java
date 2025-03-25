 
package model;

public class NumericQuestion {
    
    private int num1;
    private int num2;
    private Operator operator;
    private int result;
    private int answer;
    
    public NumericQuestion(int num1, int num2, Operator operator) {
        
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
    }
    
    private void initResult() {
    
        switch(operator) {
            
            case ADD:
                result = num1 + num2;
                break;
            case SUB:
                result = num1 - num2;
                break;
            case MUL:
                result = num1 * num2;
                break;
        } 
    }
    
    public void setAnswer(int answer) {
        
       this.answer = answer;
    }
    
    public int getAnswer() {
    
        return answer;
    }
    
    public int getResult() {
        
        return result;
    }
    
   public boolean isCorrect() {
       
       return result == answer;
   }
   
   @Override
   public String toString() {
       
       return num1 + " " + operator.getSign() + " " + num2;
   }
}
