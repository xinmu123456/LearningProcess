class A:
    def f(self, data):
        print(data)


o = A()
o.f('hello')
A.f(o, 'hello')
print(A.f, o.f)

o = A()
o.name = 'bob'

myfunc = o.f

myfunc('hello')


class A:
    pass


def f(self, data):
    print(self.name)
    print(data)


A.f = f

o = A()
o.name = 'o'
o.f('hello')


class A:
    pass


def f(self, data):
    print(self.name)
    print(data)


o = A()
o.f = f
o.name = 'o'
o.f(o, 'hello')
