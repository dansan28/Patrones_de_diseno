// Template Method Pattern
abstract class AbstractClass {
    public final void templateMethod() {
        baseOperation1();
        requiredOperations1();
        baseOperation2();
        hook1();
        requiredOperations2();
        baseOperation3();
        hook2();
    }
    
    protected void baseOperation1() {
        System.out.println("AbstractClass says: I am doing the bulk of the work");
    }
    
    protected void baseOperation2() {
        System.out.println("AbstractClass says: But I let subclasses override some operations");
    }
    
    protected void baseOperation3() {
        System.out.println("AbstractClass says: But I am doing the bulk of the work anyway");
    }
    
    protected abstract void requiredOperations1();
    protected abstract void requiredOperations2();
    
    protected void hook1() {}
    protected void hook2() {}
}

class ConcreteClass1 extends AbstractClass {
    @Override
    protected void requiredOperations1() {
        System.out.println("ConcreteClass1 says: Implemented Operation1");
    }
    
    @Override
    protected void requiredOperations2() {
        System.out.println("ConcreteClass1 says: Implemented Operation2");
    }
}

class ConcreteClass2 extends AbstractClass {
    @Override
    protected void requiredOperations1() {
        System.out.println("ConcreteClass2 says: Implemented Operation1");
    }
    
    @Override
    protected void requiredOperations2() {
        System.out.println("ConcreteClass2 says: Implemented Operation2");
    }
    
    @Override
    protected void hook1() {
        System.out.println("ConcreteClass2 says: Overridden Hook1");
    }
}

// Usage
class TemplateMethodDemo {
    public static void main(String[] args) {
        System.out.println("Same client code can work with different subclasses:");
        AbstractClass concrete1 = new ConcreteClass1();
        concrete1.templateMethod();
        
        System.out.println("\n");
        
        AbstractClass concrete2 = new ConcreteClass2();
        concrete2.templateMethod();
    }
}
