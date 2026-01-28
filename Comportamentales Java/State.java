// State Pattern
abstract class State {
    protected Context context;
    
    public void setContext(Context context) {
        this.context = context;
    }
    
    public abstract void handle1();
    public abstract void handle2();
}

class Context {
    private State state;
    
    public Context(State state) {
        this.transitionTo(state);
    }
    
    public void transitionTo(State state) {
        System.out.println("Context: Transition to " + state.getClass().getSimpleName());
        this.state = state;
        this.state.setContext(this);
    }
    
    public void request1() {
        this.state.handle1();
    }
    
    public void request2() {
        this.state.handle2();
    }
}

class ConcreteStateA extends State {
    @Override
    public void handle1() {
        System.out.println("ConcreteStateA handles request1.");
        System.out.println("ConcreteStateA wants to change the state of the context.");
        context.transitionTo(new ConcreteStateB());
    }
    
    @Override
    public void handle2() {
        System.out.println("ConcreteStateA handles request2.");
    }
}

class ConcreteStateB extends State {
    @Override
    public void handle1() {
        System.out.println("ConcreteStateB handles request1.");
    }
    
    @Override
    public void handle2() {
        System.out.println("ConcreteStateB handles request2.");
        System.out.println("ConcreteStateB wants to change the state of the context.");
        context.transitionTo(new ConcreteStateA());
    }
}

// Usage
class StateDemo {
    public static void main(String[] args) {
        Context context = new Context(new ConcreteStateA());
        context.request1();
        context.request2();
    }
}
