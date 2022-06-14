class Name:
    def __get__(self, obj, objtype):
        return 'peter'


class A:
    name = Name()


o = A()

print(o.name)
print(A.name)


class A:
    def __init__(self) -> None:
        self.name = Name()


o = A()

print(o.name)


o = A()
o.name = 'bob'
print(o.name)
print(o.__dict__)
print(A.__dict__)
