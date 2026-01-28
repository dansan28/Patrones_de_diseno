// Visitor Pattern
interface Component {
    void accept(Visitor visitor);
}

class ConcreteComponentA implements Component {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitConcreteComponentA(this);
    }
    
    public String exclusiveMethodOfConcreteComponentA() {
        return "A";
    }
}

class ConcreteComponentB implements Component {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitConcreteComponentB(this);
    }
    
    public String specialMethodOfConcreteComponentB() {
        return "B";
    }
}

interface Visitor {
    void visitConcreteComponentA(ConcreteComponentA element);
    void visitConcreteComponentB(ConcreteComponentB element);
}

class ConcreteVisitor1 implements Visitor {
    @Override
    public void visitConcreteComponentA(ConcreteComponentA element) {
        System.out.println(element.exclusiveMethodOfConcreteComponentA() + " + ConcreteVisitor1");
    }
    
    @Override
    public void visitConcreteComponentB(ConcreteComponentB element) {
        System.out.println(element.specialMethodOfConcreteComponentB() + " + ConcreteVisitor1");
    }
}

class ConcreteVisitor2 implements Visitor {
    @Override
    public void visitConcreteComponentA(ConcreteComponentA element) {
        System.out.println(element.exclusiveMethodOfConcreteComponentA() + " + ConcreteVisitor2");
    }
    
    @Override
    public void visitConcreteComponentB(ConcreteComponentB element) {
        System.out.println(element.specialMethodOfConcreteComponentB() + " + ConcreteVisitor2");
    }
}

// Usage
class VisitorDemo {
    public static void main(String[] args) {
        Component[] components = {new ConcreteComponentA(), new ConcreteComponentB()};
        
        Visitor visitor1 = new ConcreteVisitor1();
        System.out.println("The client code works with all visitors via the base Visitor interface:");
        for (Component component : components) {
            component.accept(visitor1);
        }
        
        System.out.println("\nIt allows the same client code to work with different types of visitors:");
        Visitor visitor2 = new ConcreteVisitor2();
        for (Component component : components) {
            component.accept(visitor2);
        }
    }
}
