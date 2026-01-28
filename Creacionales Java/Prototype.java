// Prototype Pattern
interface Prototype {
    Prototype clone();
}

class ConcretePrototype1 implements Prototype {
    private int value;
    
    public ConcretePrototype1(int value) {
        this.value = value;
    }
    
    public ConcretePrototype1(ConcretePrototype1 prototype) {
        this.value = prototype.value;
    }
    
    @Override
    public Prototype clone() {
        return new ConcretePrototype1(this);
    }
    
    @Override
    public String toString() {
        return "ConcretePrototype1(value=" + value + ")";
    }
}

class ConcretePrototype2 implements Prototype {
    private String data;
    
    public ConcretePrototype2(String data) {
        this.data = data;
    }
    
    public ConcretePrototype2(ConcretePrototype2 prototype) {
        this.data = prototype.data;
    }
    
    @Override
    public Prototype clone() {
        return new ConcretePrototype2(this);
    }
    
    @Override
    public String toString() {
        return "ConcretePrototype2(data=" + data + ")";
    }
}

// Usage
class PrototypeDemo {
    public static void main(String[] args) {
        ConcretePrototype1 prototype1 = new ConcretePrototype1(42);
        ConcretePrototype1 clone1 = (ConcretePrototype1) prototype1.clone();
        System.out.println("Original: " + prototype1);
        System.out.println("Clone: " + clone1);
        System.out.println("Different objects: " + (prototype1 != clone1));
        
        ConcretePrototype2 prototype2 = new ConcretePrototype2("value");
        ConcretePrototype2 clone2 = (ConcretePrototype2) prototype2.clone();
        System.out.println("\nOriginal: " + prototype2);
        System.out.println("Clone: " + clone2);
    }
}
