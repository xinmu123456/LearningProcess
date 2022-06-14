
class A:
    name = 'AAA'

    def f(self):
        print(1)


def f(self):
    print(1)


print(A.__dict__)
A = type('A', (), {"name": "AAA", 'f': f})
print(A.__dict__)

a = A()
