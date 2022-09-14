def gen(num):
    while num > 0:
        yield num
        num -= 1
    return

g = gen(5)

first = next(g)

for i in g:
    print(i)
    