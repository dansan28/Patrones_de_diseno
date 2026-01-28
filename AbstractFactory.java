// Abstract Factory Pattern
interface AbstractProductA {
    String usefulFunctionA();
}

interface AbstractProductB {
    String usefulFunctionB();
}

class ConcreteProductA1 implements AbstractProductA {
    @Override
    public String usefulFunctionA() {
        return "The result of the product A1.";
    }
}

class ConcreteProductA2 implements AbstractProductA {
    @Override
    public String usefulFunctionA() {
        return "The result of the product A2.";
    }
}

class ConcreteProductB1 implements AbstractProductB {
    @Override
    public String usefulFunctionB() {
        return "The result of the product B1.";
    }
}

class ConcreteProductB2 implements AbstractProductB {
    @Override
    public String usefulFunctionB() {
        return "The result of the product B2.";
    }
}

interface AbstractFactory {
    AbstractProductA createProductA();
    AbstractProductB createProductB();
}

class ConcreteFactory1 implements AbstractFactory {
    @Override
    public AbstractProductA createProductA() {
        return new ConcreteProductA1();
    }
    
    @Override
    public AbstractProductB createProductB() {
        return new ConcreteProductB1();
    }
}

class ConcreteFactory2 implements AbstractFactory {
    @Override
    public AbstractProductA createProductA() {
        return new ConcreteProductA2();
    }
    
    @Override
    public AbstractProductB createProductB() {
        return new ConcreteProductB2();
    }
}

// Usage
class AbstractFactoryDemo {
    public static void main(String[] args) {
        AbstractFactory factory1 = new ConcreteFactory1();
        AbstractProductA productA1 = factory1.createProductA();
        AbstractProductB productB1 = factory1.createProductB();
        System.out.println(productA1.usefulFunctionA());
        System.out.println(productB1.usefulFunctionB());
    }
}
