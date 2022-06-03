print(list(map(lambda x: x*x, [1, 2, 3])))


def f(x): return x*x


print(f)
print(f(2))


def is_odd(n):
    return n % 2 == 1


print(list(filter(is_odd, range(1, 20))))
print(list(filter(lambda n: n % 2 == 1, range(1, 20))))
