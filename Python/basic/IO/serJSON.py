import json
from re import S
from unicodedata import name
d = dict(name='Bob', age=20, score=88)

json_str = json.dumps(d)

obj = json.loads(json_str)

print(type(obj), obj)


class Student(object):
    def __init__(self, name, age, score) -> None:
        self.name = name
        self.age = age
        self.score = score


s = Student('xinmu', 11, 100)


def student2dict(std: Student):
    return {
        'name': std.name,
        'age': std.age,
        'score': std.score
    }


print(json.dumps(s, default=student2dict))

print(json.dumps(s, default=lambda obj: obj.__dict__))

json_str = json.dumps(s, default=lambda obj: obj.__dict__)


def dict2student(d):
    return Student(d['name'], d['age'], d['score'])


obj = json.loads(json_str, object_hook=dict2student)
print(type(obj), obj)
