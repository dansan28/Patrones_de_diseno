// Bridge Pattern
interface Implementation {
    String operationImplementation();
}

class ConcreteImplementationA implements Implementation {
    @Override
    public String operationImplementation() {
        return "ConcreteImplementationA: Here's the result on platform A.";
    }
}

class ConcreteImplementationB implements Implementation {
    @Override
    public String operationImplementation() {
        return "ConcreteImplementationB: Here's the result on platform B.";
    }
}

class Abstraction {
    protected Implementation implementation;
    
    public Abstraction(Implementation implementation) {
        this.implementation = implementation;
    }
    
    public String operation() {
        return "Abstraction: Base operation with:\n" + implementation.operationImplementation();
    }
}

class ExtendedAbstraction extends Abstraction {
    public ExtendedAbstraction(Implementation implementation) {
        super(implementation);
    }
    
    @Override
    public String operation() {
        return "ExtendedAbstraction: Extended operation with:\n" + implementation.operationImplementation();
    }
}

// Usage
class BridgeDemo {
    public static void main(String[] args) {
        Implementation implementationA = new ConcreteImplementationA();
        Abstraction abstraction = new Abstraction(implementationA);
        System.out.println(abstraction.operation());
        
        Implementation implementationB = new ConcreteImplementationB();
        ExtendedAbstraction extended = new ExtendedAbstraction(implementationB);
        System.out.println(extended.operation());
    }
}
