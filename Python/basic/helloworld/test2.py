import re
from tkinter import N
import os

L = ['Michael', 'Sarah', 'Tracy', 'Bob', 'Jack']

L = list(range(100))

print(L[:1])
print(L[-10:])
print(L[-1:])


def trim(s):
    while s[:1] == " ":
        s = s[1:]
    while s[-1:] == " ":
        s = s[:-1]
    return s


print(trim(" 123 "))


print(list(range(1, 11)))

print([x*x for x in range(1, 11)])

print([m + n for m in 'ABC' for n in 'xyz'])


print([d for d in os.listdir('.')])

d = {'x': 'A', 'y': 'B', 'z': 'C'}

for k, v in d.items():
    print(k, "=", v)

L = ['Hello', 'World', 'IBM', 'Apple']

print([s.lower() for s in L])

print([x for x in range(1, 11) if x % 2 == 0])


L = ['Hello', 'World', 18, 'Apple', None]
print([s.lower() for s in L if isinstance(s, str)])

print([x*x for x in range(10)])
g = (x*x for x in range(10))

print(next(g))

for n in g:
    print(n)

print("======================")


def fib(max):
    n, a, b = 0, 0, 1
    while n < max:
        yield b
        a, b = b, a + b
        n = n + 1
    return 'done'


f = fib(6)
print(f)


def odd():
    print('step 1')
    yield 1
    print('step 2')
    yield 2
    print('step 3')
    yield 3


o = odd()

print(next(o))
print(next(o))
print(next(o))

print("================")

for n in fib(6):
    print(n)

print("================")

g = fib(6)

while True:
    try:
        x = next(g)
        print('g:', x)
    except StopIteration as e:
        print('generator return value:', e.value)
        break

print("====================")


def triangles():
    L = [1]
    while True:
        yield L
        L = [1] + [L[n] + L[n + 1] for n in range(len(L) - 1)] + [1]


n = 0
for t in triangles():
    print(t)
    n = n + 1
    if n == 10:
        break
