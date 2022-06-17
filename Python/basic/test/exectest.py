

exec('a = 1')
b = 1


def f():
    a = 0
    result = {}
    exec('print(a);a = 2', locals(), result)
    print(result)
    print(a)
    globals()['a'] = 2
    print(globals()['a'])


f()

z = 7


def foo(arg):
    x = 1
    print(locals())
    print('x =', x)
    locals()['x'] = 2
    print(locals())
    print('x =', x)
    globals()['x'] = 2
    print("x =", x)


# foo(3)
