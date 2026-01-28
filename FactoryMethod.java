// Factory Method Pattern
abstract class Product {
    public abstract String operation();
}

class ConcreteProductA extends Product {
    @Override
    public String operation() {
        return "Result of ConcreteProductA";
    }
}

class ConcreteProductB extends Product {
    @Override
    public String operation() {
        return "Result of ConcreteProductB";
    }
}

abstract class Creator {
    public abstract Product factoryMethod();
    
    public String someOperation() {
        Product product = factoryMethod();
        return "Creator: " + product.operation();
    }
}

class ConcreteCreatorA extends Creator {
    @Override
    public Product factoryMethod() {
        return new ConcreteProductA();
    }
}

class ConcreteCreatorB extends Creator {
    @Override
    public Product factoryMethod() {
        return new ConcreteProductB();
    }
}

// Usage
class FactoryMethodDemo {
    public static void main(String[] args) {
        Creator creatorA = new ConcreteCreatorA();
        System.out.println(creatorA.someOperation());
        
        Creator creatorB = new ConcreteCreatorB();
        System.out.println(creatorB.someOperation());
    }
}
