from attr import attr


class Student(object):
    def __init__(self, name) -> None:
        self.name = name

    def __str__(self) -> str:
        return 'Student object (name: %s)' % self.name

    __repr__ = __str__


print(Student('xinmu'))


class Fib(object):
    def __init__(self) -> None:
        self.a, self.b = 0, 1  # 初始化两个计数器

    def __iter__(self):
        return self

    def __next__(self):
        self.a, self.b = self.b, self.a + self.b
        if self.a > 100000:
            raise StopIteration()
        return self.a

    def __getitem__(self, n):
        if isinstance(n, int):
            a, b = 1, 1
            for x in range(n):
                a, b = b, a + b
            return a
        if isinstance(n, slice):
            start = n.start
            stop = n.stop
            if start is None:
                start = 0
            a, b = 1, 1
            L = []
            for x in range(stop):
                if x >= start:
                    L.append(a)
                a, b = b, a + b
            return L


for n in Fib():
    print(n)

f = Fib()

print(f[1], f[5], f[99])

print(list(range(100)[5:10]))

print(f[:10])


class Student(object):

    def __init__(self):
        self.name = 'xinmu'

    def __getattribute__(self, attr):
        if attr == 'score':
            return 99


s = Student()
print(s.name)
print(s.score)


class Student(object):

    def __getattribute__(self, __name: str):
        if __name == 'age':
            return lambda: 25


s = Student()
print(s.age())


class Chain(object):

    def __init__(self, path='') -> None:
        self._path = path

    def __getattr__(self, __name: str):
        return Chain('%s/%s' % (self._path, __name))

    def __str__(self) -> str:
        return self._path

    __repr__ = __str__


print(Chain().status.user.timeline.list)


class Student(object):
    def __init__(self, name) -> None:
        self.name = name

    def __call__(self):
        print('my name is %s' % self.name)


s = Student('xinmu')

s()
