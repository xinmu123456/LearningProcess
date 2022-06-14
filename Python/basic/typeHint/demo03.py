from tkinter.messagebox import NO
from typing import Union


class A:
    name = 'A'


def get_name(o: A) -> str:
    return o.name


class Node:
    def __init__(self, prev: "Node") -> None:
        self.prev = prev
        self.next = None


def my_sum(lst: list[int]) -> int:
    total = 0
    for i in lst:
        total += i
    return total


my_sum([1, 2, 3])


def my_sum(d: dict[str, int]) -> int:
    total = 0
    for i in d.values():
        total += i
    return total


my_sum({'a': 1, 'b': 2, 'c': 3})


def f(x: Union[int, None]) -> int:
    if x is None:
        return 0
    return x


print(f(None))
print(f(0))
