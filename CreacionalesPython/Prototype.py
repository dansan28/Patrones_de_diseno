import copy

class Prototype:
    def __init__(self, value):
        self.value = value

    def clone(self):
        return copy.deepcopy(self)


# Uso
original = Prototype([1, 2, 3])
clone = original.clone()

clone.value.append(4)

print(original.value)  # [1, 2, 3]
print(clone.value)     # [1, 2, 3, 4]