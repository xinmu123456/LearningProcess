from email.errors import MalformedHeaderDefect
from re import M
from turtle import back
from xmlrpc.client import Marshaller


class Animal(object):
    pass


class Runnable(object):
    def run(self):
        print('running')


class Flyable(object):
    def fly(self):
        print('flying')


class Mammal(Animal):
    pass


class Bird(Animal):
    pass


class Dog(Mammal, Runnable):
    pass


class Bat(Mammal, Flyable):
    pass


class Parrot(Bird):
    pass


class Ostrich(Bird):
    pass


dog = Dog()

dog.run()

bat = Bat()

bat.fly()


class someAnimal(Mammal, Runnable, Flyable):
    pass


s = someAnimal()

s.fly()

s.run()
