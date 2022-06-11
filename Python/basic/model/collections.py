from collections import defaultdict, deque, namedtuple

from traitlets import default

Point = namedtuple('Point', ['x', 'y'])

p = Point(1, 2)

print(p.x, p.y)

Circle = namedtuple('Circle', ['x', 'y', 'r'])

q = deque(['a', 'b', 'c'])

q.append('x')

q.appendleft('y')

print(q)

dd = defaultdict(lambda: 'nil')
dd['key1'] = 'abc'
print(dd['key1'], dd['key2'])
