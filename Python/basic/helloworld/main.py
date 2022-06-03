from tkinter import N


l = ['a', 'b', 'c', 'd', 'e']

print(l[1:4])

dict = {'plat': 'vscode', 'lang': 'python', 'author': 'xinmu'}

print(dict['lang'])
del dict['plat']
print(0)


class Student:
    def __init__(self, age, name, number):
        self.age = age
        self.name = name
        self.number = number

    def test(self):
        print("student")


class BoyStudnet(Student):
    ...


class GirlStudnet(Student):
    def __init__(self, age, name, number):
        super(GirlStudnet, self).__init__(age, name, number)

    def test(self):
        print(3)


boy = BoyStudnet(10, "xinmu", 1)
print(boy.name)
boy.test()
