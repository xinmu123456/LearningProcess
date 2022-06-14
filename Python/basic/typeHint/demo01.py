import doctest


def f(a, b):
    """
    >>> f(1, 2)
    3
    """

    return a + b


if __name__ == '__main__':
    doctest.testmod()
