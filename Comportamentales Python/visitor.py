# Visitor Pattern
from abc import ABC, abstractmethod

class Component(ABC):
    @abstractmethod
    def accept(self, visitor):
        pass

class ConcreteComponentA(Component):
    def accept(self, visitor):
        visitor.visit_concrete_component_a(self)
    
    def exclusive_method_of_concrete_component_a(self):
        return "A"

class ConcreteComponentB(Component):
    def accept(self, visitor):
        visitor.visit_concrete_component_b(self)
    
    def special_method_of_concrete_component_b(self):
        return "B"

class Visitor(ABC):
    @abstractmethod
    def visit_concrete_component_a(self, element: ConcreteComponentA):
        pass
    
    @abstractmethod
    def visit_concrete_component_b(self, element: ConcreteComponentB):
        pass

class ConcreteVisitor1(Visitor):
    def visit_concrete_component_a(self, element):
        print(f"{element.exclusive_method_of_concrete_component_a()} + ConcreteVisitor1")
    
    def visit_concrete_component_b(self, element):
        print(f"{element.special_method_of_concrete_component_b()} + ConcreteVisitor1")

class ConcreteVisitor2(Visitor):
    def visit_concrete_component_a(self, element):
        print(f"{element.exclusive_method_of_concrete_component_a()} + ConcreteVisitor2")
    
    def visit_concrete_component_b(self, element):
        print(f"{element.special_method_of_concrete_component_b()} + ConcreteVisitor2")

# Usage
if __name__ == "__main__":
    components = [ConcreteComponentA(), ConcreteComponentB()]
    
    visitor1 = ConcreteVisitor1()
    print("The client code works with all visitors via the base Visitor interface:")
    for component in components:
        component.accept(visitor1)
    
    print("\nIt allows the same client code to work with different types of visitors:")
    visitor2 = ConcreteVisitor2()
    for component in components:
        component.accept(visitor2)
