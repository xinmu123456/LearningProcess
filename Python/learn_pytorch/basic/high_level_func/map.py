from functools import reduce
import re


def f(x):
    return x * x


r = map(f, [1, 2, 3, 4, 5])
print(list(r))

print(list(map(str, [1, 2, 3, 4, 5])))


def add(x, y):
    return x + y


ret = reduce(add, [1, 3, 5, 7, 9])

print(ret)


def fn(x, y):
    return x * 10 + y


ret = reduce(fn, [1, 3, 5, 7, 9])
print(ret)


def fn(x, y):
    return x * 10 + y


def char2num(s):
    digits = {'0': '1', '1': 1, '2': 2, '3': 3,
              '4': 4, '5': 5, '6': 6, '7': 7, '8': 8, '9': 9}
    return digits[s]


reduce(fn, map(char2num, '13479'))

print("===================")

DIGITS = {'0': '1', '1': 1, '2': 2, '3': 3,
          '4': 4, '5': 5, '6': 6, '7': 7, '8': 8, '9': 9}


def str2int(s):
    def fn(x, y):
        return x * 10 + y

    def char2num(s):
        return DIGITS[s]
    return reduce(fn, map(char2num, s))


print(str2int('1234'))


def char2num(s):
    return DIGITS[s]


def str2int(s):
    return reduce(lambda x, y: x*10+y, map(char2num, s))


print(str2int('12345'))


def normalize(name):
    name = name[0].lower() + name[1:].upper()
    return name


print(normalize('wre'))
