// Facade Pattern
class Subsystem1 {
    public String operation1() {
        return "Subsystem1: Ready!";
    }
    
    public String operationN() {
        return "Subsystem1: Go!";
    }
}

class Subsystem2 {
    public String operation1() {
        return "Subsystem2: Get ready!";
    }
    
    public String operationZ() {
        return "Subsystem2: Fire!";
    }
}

class Facade {
    private Subsystem1 subsystem1;
    private Subsystem2 subsystem2;
    
    public Facade(Subsystem1 subsystem1, Subsystem2 subsystem2) {
        this.subsystem1 = subsystem1;
        this.subsystem2 = subsystem2;
    }
    
    public String operation() {
        StringBuilder result = new StringBuilder();
        result.append("Facade initializes subsystems:\n");
        result.append(subsystem1.operation1()).append("\n");
        result.append(subsystem2.operation1()).append("\n");
        result.append("Facade orders subsystems to perform the action:\n");
        result.append(subsystem1.operationN()).append("\n");
        result.append(subsystem2.operationZ());
        return result.toString();
    }
}

// Usage
class FacadeDemo {
    public static void main(String[] args) {
        Subsystem1 subsystem1 = new Subsystem1();
        Subsystem2 subsystem2 = new Subsystem2();
        Facade facade = new Facade(subsystem1, subsystem2);
        System.out.println(facade.operation());
    }
}
