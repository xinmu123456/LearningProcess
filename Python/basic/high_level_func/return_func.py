def calc_sum(*args):
    ax = 0
    for n in args:
        ax += n
    return ax


def lazy_sum(*args):
    def sum():
        ax = 0
        for n in args:
            ax += n
        return ax
    return sum


f = lazy_sum(1, 2, 3, 4)
print(f)
print(f())

f1 = lazy_sum(1, 2, 3, 4)
f2 = lazy_sum(1, 2, 3, 4)
print(f1 == f2)

# 闭包


def fun_1():
    a = 3

    def fun_2(num):
        res = num + a
        return res
    return fun_2


fun = fun_1()
print(fun(3))


def count():
    fs = []
    for i in range(1, 4):
        def f():
            return i*i
        fs.append(f)
    return fs


f1, f2, f3 = count()
print(f1(), f2(), f3())


def count():
    def f(j):
        def g():
            return j*j
        return g
    fs = []
    for i in range(1, 4):
        fs.append(f(i))
    return fs


f1, f2, f3 = count()
print(f1(), f2(), f3())


def inc():
    x = 0

    def fn():
        return x + 1
    return fn


f = inc()

print(f())


def inc():
    x = 0

    def fn():
        nonlocal x
        x += 1
        return x + 1
    return fn


f = inc()

print(f())


def createCounter():
    x = 0

    def counter():
        nonlocal x
        x += 1
        return x
    return counter


f = createCounter()
print(f(), f(), f())
