from collections import namedtuple


class Position:
    def __init__(self, x, y) -> None:
        self.x = x
        self.y = y


p2 = Position(1, 2)
p3 = (1, 2)
p4 = {'x': 1, 'y': 2}


P = namedtuple('Position', ['x', 'y'])

p1 = P(1, 2)

print(p1.x, p1.y)
print(p1[0], p1[1])
