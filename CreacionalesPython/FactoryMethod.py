from abc import ABC, abstractmethod

class Transport(ABC):
    @abstractmethod
    def deliver(self):
        pass


class Truck(Transport):
    def deliver(self):
        return "Delivery by land"


class Ship(Transport):
    def deliver(self):
        return "Delivery by sea"


class Logistics:
    def create_transport(self) -> Transport:
        return Truck()


# Uso
logistics = Logistics()
transport = logistics.create_transport()
print(transport.deliver())