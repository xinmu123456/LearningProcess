from urllib3 import Retry


def fact(n):
    '''
    Calculate 1*2*...*n

    >>> fact(1)

    1

    >>> fact(-1)

    3628800

    '''

    if n < 1:
        raise ValueError()
    if n == 1:
        return 1
    return n * fact(n - 1)


if __name__ == "__main__":
    import doctest
    doctest.testmod()
