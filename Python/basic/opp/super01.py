
from typing_extensions import Self


class Person:
    def __init__(self, name) -> None:
        self.name = name


class Male(Person):
    def __init__(self, name) -> None:
        # super().__init__(name)
        super(Male, self).__init__(name)
        # Person.__init__(self, name)
        self.gender = 'male'


m = Male('peter')
print(m.gender, m.name)


class A:
    def __new__(cls: type[Self]) -> Self:
        return object.__new__(cls)


a = A()
print(a)
