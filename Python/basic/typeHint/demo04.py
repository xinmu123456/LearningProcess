from typing import Any, NoReturn


users = []

users.append('a')


def f(a: Any) -> Any:
    a.append(1)


lst: list = []
i: int = f(lst)


def error() -> NoReturn:
    pass


error()
a = 3
print(a)
