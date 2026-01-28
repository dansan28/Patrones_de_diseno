// Command Pattern
interface Command {
    String execute();
}

class Receiver {
    public String doSomething(String a) {
        return "Receiver: Working on (" + a + ".)";
    }
    
    public String doSomethingElse(String b) {
        return "Receiver: Also working on (" + b + ".)";
    }
}

class SimpleCommand implements Command {
    private String payload;
    
    public SimpleCommand(String payload) {
        this.payload = payload;
    }
    
    @Override
    public String execute() {
        return "SimpleCommand: See, I can do simple things like printing (" + payload + ")";
    }
}

class ComplexCommand implements Command {
    private Receiver receiver;
    private String a;
    private String b;
    
    public ComplexCommand(Receiver receiver, String a, String b) {
        this.receiver = receiver;
        this.a = a;
        this.b = b;
    }
    
    @Override
    public String execute() {
        StringBuilder result = new StringBuilder();
        result.append("ComplexCommand: Complex stuff should be done by a receiver object\n");
        result.append(receiver.doSomething(a)).append("\n");
        result.append(receiver.doSomethingElse(b));
        return result.toString();
    }
}

class Invoker {
    private Command onStart;
    private Command onFinish;
    
    public void setOnStart(Command command) {
        this.onStart = command;
    }
    
    public void setOnFinish(Command command) {
        this.onFinish = command;
    }
    
    public String doSomethingImportant() {
        StringBuilder result = new StringBuilder();
        if (onStart != null) {
            result.append(onStart.execute()).append("\n");
        }
        result.append("Invoker: ...doing something really important...\n");
        if (onFinish != null) {
            result.append(onFinish.execute());
        }
        return result.toString();
    }
}

// Usage
class CommandDemo {
    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        invoker.setOnStart(new SimpleCommand("Say Hi!"));
        Receiver receiver = new Receiver();
        invoker.setOnFinish(new ComplexCommand(receiver, "Send email", "Save report"));
        System.out.println(invoker.doSomethingImportant());
    }
}
