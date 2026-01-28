# Iterator Pattern
from abc import ABC, abstractmethod
from typing import Any

class Iterator(ABC):
    @abstractmethod
    def next(self):
        pass
    
    @abstractmethod
    def has_next(self):
        pass

class Aggregate(ABC):
    @abstractmethod
    def create_iterator(self):
        pass

class ConcreteIterator(Iterator):
    def __init__(self, collection):
        self._collection = collection
        self._position = 0
    
    def next(self):
        if self.has_next():
            item = self._collection[self._position]
            self._position += 1
            return item
        raise StopIteration
    
    def has_next(self):
        return self._position < len(self._collection)

class ConcreteAggregate(Aggregate):
    def __init__(self):
        self._items = []
    
    def add_item(self, item):
        self._items.append(item)
    
    def create_iterator(self):
        return ConcreteIterator(self._items)

# Usage
if __name__ == "__main__":
    aggregate = ConcreteAggregate()
    aggregate.add_item("Item 1")
    aggregate.add_item("Item 2")
    aggregate.add_item("Item 3")
    
    iterator = aggregate.create_iterator()
    while iterator.has_next():
        print(iterator.next())
