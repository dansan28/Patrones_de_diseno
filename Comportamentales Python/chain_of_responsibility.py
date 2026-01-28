# Chain of Responsibility Pattern
from abc import ABC, abstractmethod

class Handler(ABC):
    @abstractmethod
    def set_next(self, handler):
        pass
    
    @abstractmethod
    def handle(self, request):
        pass

class AbstractHandler(Handler):
    _next_handler = None
    
    def set_next(self, handler: Handler):
        self._next_handler = handler
        return handler
    
    def handle(self, request):
        if self._next_handler:
            return self._next_handler.handle(request)
        return None

class MonkeyHandler(AbstractHandler):
    def handle(self, request):
        if request == "Banana":
            return f"Monkey: I'll eat the {request}"
        else:
            return super().handle(request)

class SquirrelHandler(AbstractHandler):
    def handle(self, request):
        if request == "Nut":
            return f"Squirrel: I'll eat the {request}"
        else:
            return super().handle(request)

class DogHandler(AbstractHandler):
    def handle(self, request):
        if request == "MeatBall":
            return f"Dog: I'll eat the {request}"
        else:
            return super().handle(request)

# Usage
if __name__ == "__main__":
    monkey = MonkeyHandler()
    squirrel = SquirrelHandler()
    dog = DogHandler()
    
    monkey.set_next(squirrel).set_next(dog)
    
    for food in ["Nut", "Banana", "Cup of coffee"]:
        result = monkey.handle(food)
        if result:
            print(result)
        else:
            print(f"  {food} was left untouched.")
