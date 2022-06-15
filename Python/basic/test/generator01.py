import os


l = [x**2 for x in range(10)]
print(l)

l = [x**2 for x in range(10) if x % 2 == 0]
print(l)

l = [x**2 if x % 2 == 0 else x for x in range(10)]
print(l)

l = [n+m for n in 'abc' for m in 'xyz']
print(l)

l = [i for i in os.listdir('.')]
print(l)

l = [x+y+z for x in 'abc' for y in 'xyz' for z in 'qwe']
print(l)

l = [i if i % 2 == 0 else -i for i in range(10)]
print(l)
