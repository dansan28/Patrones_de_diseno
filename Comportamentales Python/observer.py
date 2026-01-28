# Observer Pattern
from abc import ABC, abstractmethod

class Observer(ABC):
    @abstractmethod
    def update(self, subject):
        pass

class Subject(ABC):
    def __init__(self):
        self._observers = []
    
    def attach(self, observer: Observer):
        self._observers.append(observer)
    
    def detach(self, observer: Observer):
        self._observers.remove(observer)
    
    def notify(self):
        for observer in self._observers:
            observer.update(self)

class ConcreteSubject(Subject):
    _state = None
    
    @property
    def state(self):
        return self._state
    
    @state.setter
    def state(self, value):
        self._state = value
        self.notify()

class ConcreteObserverA(Observer):
    def update(self, subject: Subject):
        if isinstance(subject, ConcreteSubject) and subject.state < 3:
            print("ConcreteObserverA: Reacted to the event")

class ConcreteObserverB(Observer):
    def update(self, subject: Subject):
        if isinstance(subject, ConcreteSubject) and (subject.state == 0 or subject.state >= 2):
            print("ConcreteObserverB: Reacted to the event")

# Usage
if __name__ == "__main__":
    subject = ConcreteSubject()
    
    observer_a = ConcreteObserverA()
    subject.attach(observer_a)
    
    observer_b = ConcreteObserverB()
    subject.attach(observer_b)
    
    subject.state = 1
    subject.state = 2
