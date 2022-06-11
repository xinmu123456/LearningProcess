

import re


class Student(object):

    @property
    def score(self):
        return self._score

    @score.setter
    def score(self, value):
        if not isinstance(value, int):
            raise ValueError('score must be an integer !')
        if value < 0 or value > 100:
            raise ValueError('out of range')
        self._score = value


s = Student()
s.score = 66
print(s.score)


class Student(object):

    @property
    def birth(self):
        return self._birth

    @birth.setter
    def birth(self, value):
        self._birth = value

    @property
    def age(self):
        return 2022 - self.birth


class Screen(object):
    def __init__(self) -> None:
        pass

    @property
    def width(self):
        return self._width

    @width.setter
    def width(self, value):
        self._width = value

    @property
    def height(self):
        return self._height

    @height.setter
    def height(self, value):
        self._height = value

    @property
    def resolution(self):
        return self._width * self._height


s = Screen()

s.height = 10

s.width = 5

print(s.resolution)
