# Strategy Pattern
from abc import ABC, abstractmethod

class Strategy(ABC):
    @abstractmethod
    def execute(self, data):
        pass

class ConcreteStrategyA(Strategy):
    def execute(self, data):
        return sorted(data)

class ConcreteStrategyB(Strategy):
    def execute(self, data):
        return sorted(data, reverse=True)

class Context:
    def __init__(self, strategy: Strategy):
        self._strategy = strategy
    
    def set_strategy(self, strategy: Strategy):
        self._strategy = strategy
    
    def do_some_business_logic(self, data):
        result = self._strategy.execute(data)
        return ", ".join(map(str, result))

# Usage
if __name__ == "__main__":
    context = Context(ConcreteStrategyA())
    print("Client: Strategy is set to normal sorting.")
    print(context.do_some_business_logic(["a", "b", "c", "d", "e"]))
    
    print("\nClient: Strategy is set to reverse sorting.")
    context.set_strategy(ConcreteStrategyB())
    print(context.do_some_business_logic(["a", "b", "c", "d", "e"]))
