// Interpreter Pattern
interface AbstractExpression {
    boolean interpret(String context);
}

class TerminalExpression implements AbstractExpression {
    private String data;
    
    public TerminalExpression(String data) {
        this.data = data;
    }
    
    @Override
    public boolean interpret(String context) {
        return context.contains(data);
    }
}

class OrExpression implements AbstractExpression {
    private AbstractExpression expr1;
    private AbstractExpression expr2;
    
    public OrExpression(AbstractExpression expr1, AbstractExpression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }
    
    @Override
    public boolean interpret(String context) {
        return expr1.interpret(context) || expr2.interpret(context);
    }
}

class AndExpression implements AbstractExpression {
    private AbstractExpression expr1;
    private AbstractExpression expr2;
    
    public AndExpression(AbstractExpression expr1, AbstractExpression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }
    
    @Override
    public boolean interpret(String context) {
        return expr1.interpret(context) && expr2.interpret(context);
    }
}

// Usage
class InterpreterDemo {
    public static void main(String[] args) {
        AbstractExpression robert = new TerminalExpression("Robert");
        AbstractExpression john = new TerminalExpression("John");
        AbstractExpression isMale = new OrExpression(robert, john);
        
        AbstractExpression julie = new TerminalExpression("Julie");
        AbstractExpression married = new TerminalExpression("Married");
        AbstractExpression isMarriedWoman = new AndExpression(julie, married);
        
        String context1 = "John";
        String context2 = "Married Julie";
        
        System.out.println("John is male? " + isMale.interpret(context1));
        System.out.println("Julie is a married woman? " + isMarriedWoman.interpret(context2));
    }
}
