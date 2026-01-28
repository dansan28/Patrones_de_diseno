// Proxy Pattern
interface Subject {
    String request();
}

class RealSubject implements Subject {
    @Override
    public String request() {
        return "RealSubject: Handling request.";
    }
}

class Proxy implements Subject {
    private RealSubject realSubject;
    
    public Proxy(RealSubject realSubject) {
        this.realSubject = realSubject;
    }
    
    @Override
    public String request() {
        if (checkAccess()) {
            String result = realSubject.request();
            logAccess();
            return result;
        }
        return "Proxy: Access denied";
    }
    
    private boolean checkAccess() {
        System.out.println("Proxy: Checking access prior to firing a real request.");
        return true;
    }
    
    private void logAccess() {
        System.out.println("Proxy: Logging the time of request.");
    }
}

// Usage
class ProxyDemo {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        Proxy proxy = new Proxy(realSubject);
        System.out.println(proxy.request());
    }
}
