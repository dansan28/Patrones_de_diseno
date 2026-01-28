from abc import ABC, abstractmethod

# Productos abstractos
class Button(ABC):
    @abstractmethod
    def paint(self):
        pass


class Checkbox(ABC):
    @abstractmethod
    def paint(self):
        pass


# Productos concretos
class WindowsButton(Button):
    def paint(self):
        return "Windows Button"


class WindowsCheckbox(Checkbox):
    def paint(self):
        return "Windows Checkbox"


# Fábrica abstracta
class GUIFactory(ABC):
    @abstractmethod
    def create_button(self) -> Button:
        pass

    @abstractmethod
    def create_checkbox(self) -> Checkbox:
        pass


# Fábrica concreta
class WindowsFactory(GUIFactory):
    def create_button(self):
        return WindowsButton()

    def create_checkbox(self):
        return WindowsCheckbox()


# Uso
factory = WindowsFactory()
button = factory.create_button()
checkbox = factory.create_checkbox()
print(button.paint(), checkbox.paint())