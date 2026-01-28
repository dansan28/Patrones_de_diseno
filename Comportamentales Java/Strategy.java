// Strategy Pattern
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

interface Strategy {
    List<String> execute(List<String> data);
}

class ConcreteStrategyA implements Strategy {
    @Override
    public List<String> execute(List<String> data) {
        Collections.sort(data);
        return data;
    }
}

class ConcreteStrategyB implements Strategy {
    @Override
    public List<String> execute(List<String> data) {
        Collections.sort(data, Collections.reverseOrder());
        return data;
    }
}

class Context {
    private Strategy strategy;
    
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }
    
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
    
    public String doSomeBusinessLogic(List<String> data) {
        List<String> result = strategy.execute(data);
        return String.join(", ", result);
    }
}

// Usage
class StrategyDemo {
    public static void main(String[] args) {
        Context context = new Context(new ConcreteStrategyA());
        System.out.println("Client: Strategy is set to normal sorting.");
        System.out.println(context.doSomeBusinessLogic(Arrays.asList("a", "b", "c", "d", "e")));
        
        System.out.println("\nClient: Strategy is set to reverse sorting.");
        context.setStrategy(new ConcreteStrategyB());
        System.out.println(context.doSomeBusinessLogic(Arrays.asList("a", "b", "c", "d", "e")));
    }
}
