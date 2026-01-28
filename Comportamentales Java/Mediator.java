// Mediator Pattern
interface Mediator {
    void notify(Object sender, String event);
}

abstract class BaseComponent {
    protected Mediator mediator;
    
    public BaseComponent(Mediator mediator) {
        this.mediator = mediator;
    }
    
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
}

class Component1 extends BaseComponent {
    public Component1(Mediator mediator) {
        super(mediator);
    }
    
    public void doA() {
        System.out.println("Component 1 does A.");
        mediator.notify(this, "A");
    }
    
    public void doB() {
        System.out.println("Component 1 does B.");
        mediator.notify(this, "B");
    }
}

class Component2 extends BaseComponent {
    public Component2(Mediator mediator) {
        super(mediator);
    }
    
    public void doC() {
        System.out.println("Component 2 does C.");
        mediator.notify(this, "C");
    }
    
    public void doD() {
        System.out.println("Component 2 does D.");
        mediator.notify(this, "D");
    }
}

class ConcreteMediator implements Mediator {
    private Component1 component1;
    private Component2 component2;
    
    public ConcreteMediator(Component1 component1, Component2 component2) {
        this.component1 = component1;
        this.component1.setMediator(this);
        this.component2 = component2;
        this.component2.setMediator(this);
    }
    
    @Override
    public void notify(Object sender, String event) {
        if (event.equals("A")) {
            System.out.println("Mediator reacts on A and triggers following operations:");
            component2.doC();
        } else if (event.equals("D")) {
            System.out.println("Mediator reacts on D and triggers following operations:");
            component1.doB();
            component2.doC();
        }
    }
}

// Usage
class MediatorDemo {
    public static void main(String[] args) {
        Component1 c1 = new Component1(null);
        Component2 c2 = new Component2(null);
        ConcreteMediator mediator = new ConcreteMediator(c1, c2);
        
        System.out.println("Client triggers operation A.");
        c1.doA();
        
        System.out.println("\nClient triggers operation D.");
        c2.doD();
    }
}
