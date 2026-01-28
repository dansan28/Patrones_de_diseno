// Chain of Responsibility Pattern
abstract class Handler {
    private Handler next;
    
    public Handler setNext(Handler handler) {
        this.next = handler;
        return handler;
    }
    
    public abstract String handle(String request);
    
    protected String passToNext(String request) {
        if (next != null) {
            return next.handle(request);
        }
        return null;
    }
}

class MonkeyHandler extends Handler {
    @Override
    public String handle(String request) {
        if ("Banana".equals(request)) {
            return "Monkey: I'll eat the " + request;
        }
        return passToNext(request);
    }
}

class SquirrelHandler extends Handler {
    @Override
    public String handle(String request) {
        if ("Nut".equals(request)) {
            return "Squirrel: I'll eat the " + request;
        }
        return passToNext(request);
    }
}

class DogHandler extends Handler {
    @Override
    public String handle(String request) {
        if ("MeatBall".equals(request)) {
            return "Dog: I'll eat the " + request;
        }
        return passToNext(request);
    }
}

// Usage
class ChainOfResponsibilityDemo {
    public static void main(String[] args) {
        Handler monkey = new MonkeyHandler();
        Handler squirrel = new SquirrelHandler();
        Handler dog = new DogHandler();
        
        monkey.setNext(squirrel).setNext(dog);
        
        String[] foods = {"Nut", "Banana", "Cup of coffee"};
        for (String food : foods) {
            String result = monkey.handle(food);
            if (result != null) {
                System.out.println(result);
            } else {
                System.out.println("  " + food + " was left untouched.");
            }
        }
    }
}
