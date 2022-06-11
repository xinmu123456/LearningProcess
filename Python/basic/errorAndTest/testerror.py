# def foo():
#     r = some_function()
#     if r == (-1):
#         return (-1)
#     return r

# def bar():
#     r = foo()
#     if r == (-1):
#         print('error')
#     else:
#         pass


import logging
from multiprocessing.sharedctypes import Value


try:
    print('try...')
    r = 10 / 0
    print('result:', r)
except ZeroDivisionError as e:
    print('except:', e)
finally:
    print('finally')
print('end')


try:
    print('try...')
    r = 10 / int('a')
    print('result:', r)
except ValueError as e:
    print('ValueError:', e)
except ZeroDivisionError as e:
    print('ZeroDivisionError:', e)
else:
    print('no error')
finally:
    print('finally')
print('end')


def foo(s):
    return 10/int(s)


def bar(s):
    return foo(s)/2


def main():
    try:
        bar('0')
    except Exception as e:
        print('error:', e)
    finally:
        print('finally')


main()


def main():
    try:
        bar('0')
    except Exception as e:
        logging.exception(e)


main()


class FooError(ValueError):
    pass


def foo(s):
    n = int(s)
    if n == 0:
        raise FooError('invalid value:%s' % s)
    return 10/n


# foo('0')

def foo(s):
    n = int(s)
    if n == 0:
        raise ValueError('invalid value:%s' % s)
    return 10/n


def bar():
    try:
        foo('0')
    except:
        print('valueError')
        raise


bar()
