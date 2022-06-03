import math
import re

from urllib3 import Retry


classmates = ['Michael', 'Bob', 'Tracy']

print(classmates)

print(len(classmates))

for name in classmates:
    print(name)

# 循环
sum = 0
for x in [1, 2, 3, 4, 5, 6]:
    sum += x
print(sum)

# 字典
dict = {'name': 'xinmu', 'age': 15}

print(dict['age'])
print(dict['name'])

print(dict.get('user'), -1)

# 集合
s = set([1, 2, 3])
print(s)
s.add(4)
s.add(3)
print(s)
s.remove(4)
print(s)


a = ['c', 'b', 'a']
a.sort()
print(a)

a = 'abc'
a = a.replace('a', 'A')
print(a)


# 函数
print(abs(100))
print(abs(-20))


def my_abs(x):
    if x >= 0:
        return x
    else:
        return -x


print(my_abs(-99))


def sqardratic(a, b, c):
    x = b**2 - 4*a*c
    if x > 0:
        x1 = (-b+math.sqrt(b**2-4*a*c))/(2*a)
        x2 = (-b-math.sqrt(b**2-4*a*c))/(2*a)
        print('共有两个值')
        return (x1, x2)
    elif x == 0:
        x1 = (-b)/2*a
        print('有一个值')
        return (x1)
    elif x < 0:
        return '无此值'


# a = float(input('请输入'))
# b = float(input('请输入'))
# c = float(input('请输入'))
# print(sqardratic(a, b, c))

def power(x, n=2):
    s = 1
    while n > 0:
        n = n - 1
        s = s * x
    return s


print(power(5))


def calc(*numbers):
    sum = 0
    for n in numbers:
        sum += n*n
    return sum


print(calc(1, 2, 3))
