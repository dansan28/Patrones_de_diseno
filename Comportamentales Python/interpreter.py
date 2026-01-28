# Interpreter Pattern
from abc import ABC, abstractmethod

class AbstractExpression(ABC):
    @abstractmethod
    def interpret(self, context):
        pass

class TerminalExpression(AbstractExpression):
    def __init__(self, data):
        self.data = data
    
    def interpret(self, context):
        return self.data in context

class OrExpression(AbstractExpression):
    def __init__(self, expr1: AbstractExpression, expr2: AbstractExpression):
        self.expr1 = expr1
        self.expr2 = expr2
    
    def interpret(self, context):
        return self.expr1.interpret(context) or self.expr2.interpret(context)

class AndExpression(AbstractExpression):
    def __init__(self, expr1: AbstractExpression, expr2: AbstractExpression):
        self.expr1 = expr1
        self.expr2 = expr2
    
    def interpret(self, context):
        return self.expr1.interpret(context) and self.expr2.interpret(context)

# Usage
if __name__ == "__main__":
    robert = TerminalExpression("Robert")
    john = TerminalExpression("John")
    is_male = OrExpression(robert, john)
    
    julie = TerminalExpression("Julie")
    married = TerminalExpression("Married")
    is_married_woman = AndExpression(julie, married)
    
    context1 = "John"
    context2 = "Married Julie"
    
    print(f"John is male? {is_male.interpret(context1)}")
    print(f"Julie is a married woman? {is_married_woman.interpret(context2)}")
