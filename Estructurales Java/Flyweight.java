// Flyweight Pattern
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Arrays;

interface Flyweight {
    String operation(String extrinsicState);
}

class ConcreteFlyweight implements Flyweight {
    private String intrinsicState;
    
    public ConcreteFlyweight(String intrinsicState) {
        this.intrinsicState = intrinsicState;
    }
    
    @Override
    public String operation(String extrinsicState) {
        return "ConcreteFlyweight: Intrinsic(" + intrinsicState + "), Extrinsic(" + extrinsicState + ")";
    }
}

class FlyweightFactory {
    private Map<String, Flyweight> flyweights = new HashMap<>();
    
    public FlyweightFactory(List<String> initialFlyweights) {
        for (String state : initialFlyweights) {
            flyweights.put(state, new ConcreteFlyweight(state));
        }
    }
    
    public Flyweight getFlyweight(String key) {
        if (!flyweights.containsKey(key)) {
            flyweights.put(key, new ConcreteFlyweight(key));
        }
        return flyweights.get(key);
    }
    
    public void listFlyweights() {
        System.out.println("Flyweights: " + flyweights.keySet());
    }
}

// Usage
class FlyweightDemo {
    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory(Arrays.asList("A", "B"));
        
        Flyweight flyweight1 = factory.getFlyweight("A");
        System.out.println(flyweight1.operation("extrinsic1"));
        
        Flyweight flyweight2 = factory.getFlyweight("B");
        System.out.println(flyweight2.operation("extrinsic2"));
        
        Flyweight flyweight3 = factory.getFlyweight("A");
        System.out.println("Same flyweight: " + (flyweight1 == flyweight3));
        
        factory.listFlyweights();
    }
}
