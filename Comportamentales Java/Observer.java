// Observer Pattern
import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(Subject subject);
}

abstract class Subject {
    private List<Observer> observers = new ArrayList<>();
    
    public void attach(Observer observer) {
        observers.add(observer);
    }
    
    public void detach(Observer observer) {
        observers.remove(observer);
    }
    
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}

class ConcreteSubject extends Subject {
    private int state;
    
    public int getState() {
        return state;
    }
    
    public void setState(int state) {
        this.state = state;
        notifyObservers();
    }
}

class ConcreteObserverA implements Observer {
    @Override
    public void update(Subject subject) {
        if (subject instanceof ConcreteSubject) {
            ConcreteSubject concreteSubject = (ConcreteSubject) subject;
            if (concreteSubject.getState() < 3) {
                System.out.println("ConcreteObserverA: Reacted to the event");
            }
        }
    }
}

class ConcreteObserverB implements Observer {
    @Override
    public void update(Subject subject) {
        if (subject instanceof ConcreteSubject) {
            ConcreteSubject concreteSubject = (ConcreteSubject) subject;
            if (concreteSubject.getState() == 0 || concreteSubject.getState() >= 2) {
                System.out.println("ConcreteObserverB: Reacted to the event");
            }
        }
    }
}

// Usage
class ObserverDemo {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        
        Observer observerA = new ConcreteObserverA();
        subject.attach(observerA);
        
        Observer observerB = new ConcreteObserverB();
        subject.attach(observerB);
        
        subject.setState(1);
        subject.setState(2);
    }
}
