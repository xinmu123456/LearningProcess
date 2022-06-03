

from audioop import reverse
from cv2 import sort


def is_odd(n):
    return n % 2 == 1


l = list(filter((is_odd), [1, 2, 4, 5, 6, 9, 10, 15]))
print(l)


def not_empty(s):
    return s and s.strip()


print(list(filter(not_empty, ['A', 'B', '', None, 'C', ' '])))


# 生成器
def _odd_iter():
    n = 1
    while True:
        n = n + 2
        yield n


def _not_divisible(n):
    return lambda x: x % n > 0


def primes():
    yield 2
    it = _odd_iter()  # 初始化序列
    while True:
        n = next(it)
        yield n
        it = filter(_not_divisible, it)  # 构建序列


for n in primes():
    if n < 1000:
        print(n)
    else:
        break


print(sorted([36, 5, -12, 9, -21]))

print(sorted(['bob', 'about', 'Zoo', 'Credit']))

print(sorted(['bob', 'about', 'Zoo', 'Credit'], key=str.lower))

print(sorted(['bob', 'about', 'Zoo', 'Credit'], key=str.lower, reverse=True))


L = [('Bob', 75), ('Adam', 92), ('Bart', 66), ('Lisa', 88)]


def by_name(t):
    return t[0]


def by_score(t):
    return -t[1]


print(sorted(L, key=by_score))
