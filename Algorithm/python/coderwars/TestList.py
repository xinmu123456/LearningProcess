# 本文件主要测试py的切片语法


from functools import reduce
from numpy import square


l = list(i*i for i in range(1, 9))

# print(l)

# print('*'*20)
l = [x ** 2 for x in range(1, 11) if x % 2 == 0]

# print(l)

l = [[x ** i for i in [2, 3, 4]] for x in range(1, 11) if x % 2 == 0]

# print(l)

l = [[True if x ** i % 3 == 0 else False for i in [2, 3, 4]]
     for x in range(1, 11) if x % 2 == 0]

# print(l)
a = ['a', 'b', 'c']
b = [1, 2, 3, 4]

for a, b in zip(a, b):
    print(a, b)
a = [1, 3, 3, 4, 4, 5, 5]

print(list(set(a)))

l = list(map(square, a))
print(l)


def func(x):
    if x in ['a', 'e', 'i', 'o']:
        return True
    else:
        return False


print(list(filter(func, 'hello')))

print(type('hello'))
print(type(str('hello')))


def add(x, y):
    return x + y


l = reduce(lambda x, y: x + y, [1, 2, 3])
print(l)


for i in range(10, 1, -1):
    print(i, end='')


l = [1, 2, 3, 4, 5]

print(l[::-2])

for i in range(1, 10, 2):
    print(i)
