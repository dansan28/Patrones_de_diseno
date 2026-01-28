# Composite Pattern
from abc import ABC, abstractmethod

class Component(ABC):
    @abstractmethod
    def operation(self):
        pass
    
    @abstractmethod
    def add(self, component):
        pass
    
    @abstractmethod
    def remove(self, component):
        pass
    
    @abstractmethod
    def get_child(self, index):
        pass

class Leaf(Component):
    def __init__(self, name):
        self.name = name
    
    def operation(self):
        return f"Leaf {self.name}"
    
    def add(self, component):
        raise NotImplementedError("Cannot add to leaf")
    
    def remove(self, component):
        raise NotImplementedError("Cannot remove from leaf")
    
    def get_child(self, index):
        raise NotImplementedError("Leaf has no children")

class Composite(Component):
    def __init__(self, name):
        self.name = name
        self.children = []
    
    def operation(self):
        results = [f"Composite {self.name}"]
        for child in self.children:
            results.append(child.operation())
        return "\n".join(results)
    
    def add(self, component):
        self.children.append(component)
    
    def remove(self, component):
        self.children.remove(component)
    
    def get_child(self, index):
        return self.children[index]

# Usage
if __name__ == "__main__":
    tree = Composite("root")
    branch1 = Composite("branch1")
    branch2 = Composite("branch2")
    
    leaf1 = Leaf("leaf1")
    leaf2 = Leaf("leaf2")
    leaf3 = Leaf("leaf3")
    
    branch1.add(leaf1)
    branch1.add(leaf2)
    branch2.add(leaf3)
    
    tree.add(branch1)
    tree.add(branch2)
    
    print(tree.operation())
