# Flyweight Pattern
from abc import ABC, abstractmethod

class Flyweight(ABC):
    @abstractmethod
    def operation(self, extrinsic_state):
        pass

class ConcreteFlyweight(Flyweight):
    def __init__(self, intrinsic_state):
        self._intrinsic_state = intrinsic_state
    
    def operation(self, extrinsic_state):
        return f"ConcreteFlyweight: Intrinsic({self._intrinsic_state}), Extrinsic({extrinsic_state})"

class FlyweightFactory:
    _flyweights = {}
    
    def __init__(self, initial_flyweights):
        for state in initial_flyweights:
            self._flyweights[state] = ConcreteFlyweight(state)
    
    def get_flyweight(self, key):
        if key not in self._flyweights:
            self._flyweights[key] = ConcreteFlyweight(key)
        return self._flyweights[key]
    
    def list_flyweights(self):
        return list(self._flyweights.keys())

# Usage
if __name__ == "__main__":
    factory = FlyweightFactory(["A", "B"])
    
    flyweight1 = factory.get_flyweight("A")
    print(flyweight1.operation("extrinsic1"))
    
    flyweight2 = factory.get_flyweight("B")
    print(flyweight2.operation("extrinsic2"))
    
    flyweight3 = factory.get_flyweight("A")
    print(f"Same flyweight: {flyweight1 is flyweight3}")
    
    print(f"Flyweights: {factory.list_flyweights()}")
