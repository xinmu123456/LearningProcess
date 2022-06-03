def avg(x, y):
    return (x + y) / 2


a = avg(10, 20)


# print(a)


def f(name, a, b):
    return name(a, b)


ret = f(avg, 1, 2)
# print(ret)

lst = ['20201901234', '123412412', '23131321', '123123123123']


def byClass(xuehao):
    return xuehao[4:6]


ret = sorted(lst, key=byClass)
print(ret)
