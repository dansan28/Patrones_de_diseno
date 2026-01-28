// Adapter Pattern
class Target {
    public String request() {
        return "Target: The default target's behavior.";
    }
}

class Adaptee {
    public String specificRequest() {
        return ".eetpadA eht fo roivaheb laicepS";
    }
}

class Adapter extends Target {
    private Adaptee adaptee;
    
    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }
    
    @Override
    public String request() {
        String result = adaptee.specificRequest();
        return "Adapter: (TRANSLATED) " + new StringBuilder(result).reverse().toString();
    }
}

// Usage
class AdapterDemo {
    public static void main(String[] args) {
        Target target = new Target();
        System.out.println(target.request());
        
        Adaptee adaptee = new Adaptee();
        Adapter adapter = new Adapter(adaptee);
        System.out.println(adapter.request());
    }
}
