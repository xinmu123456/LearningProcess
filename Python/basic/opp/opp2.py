

import this


class Student(object):
    def __init__(self, name, score) -> None:
        self.__name = name
        self.__score = score

    def print_score(self):
        print('%s: %s' % (self.__name, self.__score))

    def get_name(self):
        return self.__name

    def get_score(self):
        return self.__score

    def set_name(self, name):
        self.__name = name

    def set_score(self, score):
        self.__score = score


bart = Student('xinmu', 123)
print(bart.__name)
