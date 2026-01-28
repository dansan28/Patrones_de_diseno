# Adapter Pattern
class Target:
    def request(self):
        return "Target: The default target's behavior."

class Adaptee:
    def specific_request(self):
        return ".eetpadA eht fo roivaheb laicepS"

class Adapter(Target):
    def __init__(self, adaptee: Adaptee):
        self.adaptee = adaptee
    
    def request(self):
        return f"Adapter: (TRANSLATED) {self.adaptee.specific_request()[::-1]}"

# Usage
if __name__ == "__main__":
    target = Target()
    print(target.request())
    
    adaptee = Adaptee()
    adapter = Adapter(adaptee)
    print(adapter.request())
