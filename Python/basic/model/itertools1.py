import itertools
from tokenize import group

natuals = itertools.cycle('ABC')

# for n in natuals:
#     print(n)

ns = itertools.repeat('A', 3)

for n in ns:
    print(n)

for c in itertools.chain('ABC', 'XYZ'):
    print(c)

for key, group in itertools.groupby('AAaBbBcCaAA'):
    print(key, list(group))

for key, group in itertools.groupby('AAaBbBcCaAA', lambda c: c.upper()):
    print(key, list(group))


def pi(N):
    # 创建一个奇数序列
    odds = itertools.count(1, 2)

    # 提取前n项的和
    od = itertools.takewhile(lambda x: x <= 2*N - 1, odds)

    # 添加正负号
    od = (4/x if (x - 1) % 4 == 0 else -4/x for x in od)
    return sum(od)


print(pi(100000))
