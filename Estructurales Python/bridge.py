# Bridge Pattern
from abc import ABC, abstractmethod

class Implementation(ABC):
    @abstractmethod
    def operation_implementation(self):
        pass

class ConcreteImplementationA(Implementation):
    def operation_implementation(self):
        return "ConcreteImplementationA: Here's the result on platform A."

class ConcreteImplementationB(Implementation):
    def operation_implementation(self):
        return "ConcreteImplementationB: Here's the result on platform B."

class Abstraction:
    def __init__(self, implementation: Implementation):
        self.implementation = implementation
    
    def operation(self):
        return f"Abstraction: Base operation with:\n{self.implementation.operation_implementation()}"

class ExtendedAbstraction(Abstraction):
    def operation(self):
        return f"ExtendedAbstraction: Extended operation with:\n{self.implementation.operation_implementation()}"

# Usage
if __name__ == "__main__":
    implementation_a = ConcreteImplementationA()
    abstraction = Abstraction(implementation_a)
    print(abstraction.operation())
    
    implementation_b = ConcreteImplementationB()
    extended = ExtendedAbstraction(implementation_b)
    print(extended.operation())
