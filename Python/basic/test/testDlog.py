from typing import Callable
import time


def logging(level):
    def outer_wrapper(func: Callable):
        print(f"[{level}]: enter function {func.__name__}")

        def inner_wrapper(*args, **kwargs):
            st = time.time()
            func(*args, **kwargs)
            print(f"takes time {time.time() - st}")
        return inner_wrapper
    return outer_wrapper


@logging(level='debug')
def add(x, y):
    print(x + y)


add(1, 2)

logging(level='debug')(add)(1, 2)
