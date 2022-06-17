
from collections import Counter, defaultdict, namedtuple


t = (1, 2, 3)

print(t)
print(*t)

l = [1, 2, 3]
print(l)
print(*l)


d = [1, 3, 42]

for index, item in enumerate(d):
    print(f"{index} => {item}")


Point = namedtuple('Point', ['x', 'y'])
p1 = Point(2, 2)
print(p1)
p1 = p1._replace(x=1)
print(*p1)

d = defaultdict(list)
d.update({1: [1]})
print(d[1], d[0])

s = 'abbccc'
c = Counter(s)

print(c)

c = Counter(a=4, b=2, c=0, d=-2)
print(list(c.elements()))
del c['a']
print(c)
