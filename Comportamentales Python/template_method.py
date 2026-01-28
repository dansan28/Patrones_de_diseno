# Template Method Pattern
from abc import ABC, abstractmethod

class AbstractClass(ABC):
    def template_method(self):
        self.base_operation1()
        self.required_operations1()
        self.base_operation2()
        self.hook1()
        self.required_operations2()
        self.base_operation3()
        self.hook2()
    
    def base_operation1(self):
        print("AbstractClass says: I am doing the bulk of the work")
    
    def base_operation2(self):
        print("AbstractClass says: But I let subclasses override some operations")
    
    def base_operation3(self):
        print("AbstractClass says: But I am doing the bulk of the work anyway")
    
    @abstractmethod
    def required_operations1(self):
        pass
    
    @abstractmethod
    def required_operations2(self):
        pass
    
    def hook1(self):
        pass
    
    def hook2(self):
        pass

class ConcreteClass1(AbstractClass):
    def required_operations1(self):
        print("ConcreteClass1 says: Implemented Operation1")
    
    def required_operations2(self):
        print("ConcreteClass1 says: Implemented Operation2")

class ConcreteClass2(AbstractClass):
    def required_operations1(self):
        print("ConcreteClass2 says: Implemented Operation1")
    
    def required_operations2(self):
        print("ConcreteClass2 says: Implemented Operation2")
    
    def hook1(self):
        print("ConcreteClass2 says: Overridden Hook1")

# Usage
if __name__ == "__main__":
    print("Same client code can work with different subclasses:")
    concrete1 = ConcreteClass1()
    concrete1.template_method()
    
    print("\n")
    
    concrete2 = ConcreteClass2()
    concrete2.template_method()
