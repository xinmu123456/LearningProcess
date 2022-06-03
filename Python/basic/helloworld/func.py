import re


print(abs)
f = abs
print(f(-10))


def add(x, y, f):
    return f(x) + f(y)


print(add(-5, 6, abs))
