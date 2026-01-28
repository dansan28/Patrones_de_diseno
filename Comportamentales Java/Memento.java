// Memento Pattern
class Memento {
    private String state;
    
    public Memento(String state) {
        this.state = state;
    }
    
    public String getState() {
        return state;
    }
}

class Originator {
    private String state;
    
    public void setState(String state) {
        System.out.println("Originator: Setting state to " + state);
        this.state = state;
    }
    
    public Memento saveToMemento() {
        System.out.println("Originator: Saving to Memento.");
        return new Memento(state);
    }
    
    public void restoreFromMemento(Memento memento) {
        state = memento.getState();
        System.out.println("Originator: State after restoring from Memento: " + state);
    }
}

class Caretaker {
    private java.util.List<Memento> mementos = new java.util.ArrayList<>();
    
    public void backup(Memento memento) {
        System.out.println("Caretaker: Saving Originator's state...");
        mementos.add(memento);
    }
    
    public void undo(Originator originator) {
        if (mementos.isEmpty()) {
            return;
        }
        
        Memento memento = mementos.remove(mementos.size() - 1);
        System.out.println("Caretaker: Restoring state to: " + memento.getState());
        originator.restoreFromMemento(memento);
    }
    
    public void showHistory() {
        System.out.println("Caretaker: Here's the list of mementos:");
        for (Memento memento : mementos) {
            System.out.println(memento.getState());
        }
    }
}

// Usage
class MementoDemo {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();
        
        originator.setState("State #1");
        originator.setState("State #2");
        caretaker.backup(originator.saveToMemento());
        
        originator.setState("State #3");
        caretaker.backup(originator.saveToMemento());
        
        originator.setState("State #4");
        System.out.println("\nCurrent state: " + originator.toString());
        
        caretaker.undo(originator);
        caretaker.undo(originator);
    }
}
