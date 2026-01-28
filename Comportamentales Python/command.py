# Command Pattern
from abc import ABC, abstractmethod

class Command(ABC):
    @abstractmethod
    def execute(self):
        pass

class Receiver:
    def do_something(self, a):
        return f"Receiver: Working on ({a}.)"
    
    def do_something_else(self, b):
        return f"Receiver: Also working on ({b}.)"

class SimpleCommand(Command):
    def __init__(self, payload):
        self._payload = payload
    
    def execute(self):
        return f"SimpleCommand: See, I can do simple things like printing ({self._payload})"

class ComplexCommand(Command):
    def __init__(self, receiver: Receiver, a, b):
        self._receiver = receiver
        self._a = a
        self._b = b
    
    def execute(self):
        results = []
        results.append("ComplexCommand: Complex stuff should be done by a receiver object")
        results.append(self._receiver.do_something(self._a))
        results.append(self._receiver.do_something_else(self._b))
        return "\n".join(results)

class Invoker:
    def __init__(self):
        self._on_start = None
        self._on_finish = None
    
    def set_on_start(self, command: Command):
        self._on_start = command
    
    def set_on_finish(self, command: Command):
        self._on_finish = command
    
    def do_something_important(self):
        results = []
        if isinstance(self._on_start, Command):
            results.append(self._on_start.execute())
        results.append("Invoker: ...doing something really important...")
        if isinstance(self._on_finish, Command):
            results.append(self._on_finish.execute())
        return "\n".join(results)

# Usage
if __name__ == "__main__":
    invoker = Invoker()
    invoker.set_on_start(SimpleCommand("Say Hi!"))
    receiver = Receiver()
    invoker.set_on_finish(ComplexCommand(receiver, "Send email", "Save report"))
    print(invoker.do_something_important())
