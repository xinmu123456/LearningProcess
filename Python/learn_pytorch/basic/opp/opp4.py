from itertools import count


class Student(object):
    score = 100
    count = 0

    def __init__(self, name) -> None:
        self.name = name
        Student.count += 1


s = Student('xinmu1')
s = Student('xinmu2')
s = Student('xinmu3')
print(s.score)
print(Student.count)
