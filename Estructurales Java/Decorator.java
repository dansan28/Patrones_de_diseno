// Decorator Pattern
abstract class Component {
    public abstract String operation();
}

class ConcreteComponent extends Component {
    @Override
    public String operation() {
        return "ConcreteComponent";
    }
}

abstract class Decorator extends Component {
    protected Component component;
    
    public Decorator(Component component) {
        this.component = component;
    }
    
    @Override
    public String operation() {
        return component.operation();
    }
}

class ConcreteDecoratorA extends Decorator {
    public ConcreteDecoratorA(Component component) {
        super(component);
    }
    
    @Override
    public String operation() {
        return "ConcreteDecoratorA(" + component.operation() + ")";
    }
}

class ConcreteDecoratorB extends Decorator {
    public ConcreteDecoratorB(Component component) {
        super(component);
    }
    
    @Override
    public String operation() {
        return "ConcreteDecoratorB(" + component.operation() + ")";
    }
}

// Usage
class DecoratorDemo {
    public static void main(String[] args) {
        Component simple = new ConcreteComponent();
        System.out.println("Client: I got a simple component: " + simple.operation());
        
        Component decorator1 = new ConcreteDecoratorA(simple);
        Component decorator2 = new ConcreteDecoratorB(decorator1);
        System.out.println("Client: Now I've got a decorated component: " + decorator2.operation());
    }
}
