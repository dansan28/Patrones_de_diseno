# Memento Pattern
class Memento:
    def __init__(self, state):
        self._state = state
    
    def get_state(self):
        return self._state

class Originator:
    def __init__(self):
        self._state = None
    
    def set_state(self, state):
        print(f"Originator: Setting state to {state}")
        self._state = state
    
    def save_to_memento(self):
        print(f"Originator: Saving to Memento.")
        return Memento(self._state)
    
    def restore_from_memento(self, memento: Memento):
        self._state = memento.get_state()
        print(f"Originator: State after restoring from Memento: {self._state}")

class Caretaker:
    def __init__(self):
        self._mementos = []
    
    def backup(self, memento: Memento):
        print("Caretaker: Saving Originator's state...")
        self._mementos.append(memento)
    
    def undo(self, originator: Originator):
        if not self._mementos:
            return
        
        memento = self._mementos.pop()
        print("Caretaker: Restoring state to: " + str(memento.get_state()))
        originator.restore_from_memento(memento)
    
    def show_history(self):
        print("Caretaker: Here's the list of mementos:")
        for memento in self._mementos:
            print(memento.get_state())

# Usage
if __name__ == "__main__":
    originator = Originator()
    caretaker = Caretaker()
    
    originator.set_state("State #1")
    originator.set_state("State #2")
    caretaker.backup(originator.save_to_memento())
    
    originator.set_state("State #3")
    caretaker.backup(originator.save_to_memento())
    
    originator.set_state("State #4")
    print(f"\nCurrent state: {originator._state}")
    
    caretaker.undo(originator)
    caretaker.undo(originator)
