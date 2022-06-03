from cgitb import text
import functools
import imp
import re
from turtle import st
import time

from numpy import tri


def log(func):
    def wrapper(*args, **kw):
        print('call %s():' % func.__name__)
        return func(*args, **kw)
    return wrapper


def log(text):
    def decorator(func):
        @functools.wraps(func)
        def wrapper(*args, **kw):
            print('%s %s()' % (text, func.__name__))
            return func(*args, **kw)
        return wrapper
    return decorator


@log('execute')
def now():
    print('2022-5-31')


f = now
f()

now = log('execute')(now)

print(now.__name__)


def adaptiveLog(ag=''):
    def adaptiveWrapper(funcag, text, *args, **kw):
        print('%s before %s' % (text, funcag.__name__))
        res = funcag(*args, **kw)
        print('%s after %' % (text, funcag.__name__))
        return res
    if(not isinstance(ag, str)):
        @functools.wraps(ag)
        def wrapper(*args, **kw):
            return adaptiveWrapper(ag, 'no arg', *args, **kw)
        return wrapper
    else:
        def decor(func):
            @functools.wraps(func)
            def wrapper(*args, **kw):
                return adaptiveWrapper(func, ag, *args, **kw)
            return wrapper
        return decor


@adaptiveLog()
def test():
    print('test')


def double(x):
    return x*2


def triple(x):
    return x*3


print(double(2))


def calc_number(func, x):
    print(func(x))


calc_number(double, 3)
calc_number(triple, 3)


def get_multiple_func(n):

    def multiple(x):
        return n * x

    return multiple


double = get_multiple_func(2)
triple = get_multiple_func(3)

print(double(2), triple(3))


def dec(f):
    pass


@dec
def double(x):
    return x*2


def timeit(f):

    def wrapper(*args, **kwargs):
        start = time.time()
        ret = f(*args, **kwargs)
        print(time.time() - start)
        return ret
    return wrapper


@timeit
def my_func(x):
    time.sleep(x)


@timeit
def other_func(x):
    print('other_func')


my_func(1)
other_func(1)
