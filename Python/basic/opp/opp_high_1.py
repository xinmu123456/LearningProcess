from re import S
from types import MethodType


class Student(object):
    pass


s = Student()
s.name = 'xinmu'
print(s.name)


def set_age(self, age):
    self.age = age


s.set_age = MethodType(set_age, s)
s.set_age(25)
print(s.age)

s2 = Student()

Student.set_age = set_age

s2.set_age(2)

s2.score = 100


class Student(object):
    __slots__ = ('name', 'age')


s = Student()

s.name = 'xinmu'

s.score = 100
