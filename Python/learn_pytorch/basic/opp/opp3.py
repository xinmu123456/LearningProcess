from telnetlib import DO
from webbrowser import get


class Animal(object):
    def run(self):
        print('animal is running')


class Dog(Animal):
    def run(self):
        print('dog is running')

    def eat(self):
        print('dog is eating')


class Cat(Animal):
    def run(self):
        print('cat is running')

    def eat(self):
        print('cat is eating')


def run_twice(animal):
    for i in range(2):
        animal.run()


animal = Animal()

dog = Dog()
dog.run()
dog.eat()

cat = Cat()
cat.run()
cat.eat()

print(isinstance(dog, Animal))
print(isinstance(animal, Animal))
print(isinstance(animal, Dog))

run_twice(dog)

print(type(dog), type(animal), type(123))

print(isinstance([1, 2, 3], (list, tuple)))

print(dir('abc'), dir(dog), dir(animal))

print(dog.__str__)

print('abc'.upper())


class MyObject(object):
    def __init__(self) -> None:
        self.x = 9

    def power(self):
        return self.x * self.x


obj = MyObject()

print(hasattr(obj, 'x'))
print(obj.x)
print(hasattr(obj, 'y'))

setattr(obj, 'y', 10)
print(hasattr(obj, 'y'))
print(obj.y)

print(getattr(obj, 'z', 404))
print(hasattr(obj, 'power'))
fn = getattr(obj, 'power')
print(fn())
