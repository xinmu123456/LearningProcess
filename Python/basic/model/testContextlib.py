import imp
from typing_extensions import Self
from contextlib import closing, contextmanager
from unicodedata import name
from urllib.request import urlopen


class Query(object):

    def __init__(self, name):
        self.name = name

    def __enter__(self):
        print('Begin')
        return self

    def __exit__(self, exc_type, exc_value, traceback):
        if exc_type:
            print('Error')
        else:
            print('End')

    def query(self):
        print('Query info about %s...' % self.name)


with Query('bob') as q:
    q.query()


class Query(object):

    def __init__(self, name):
        self.name = name

    def query(self):
        print('query info about %s...' % self.name)


@contextmanager
def create_query(name):
    print('begin')
    q = Query(name)
    yield q
    print('end')


with create_query('Bob') as q:
    q.query()


@contextmanager
def tag(name):
    print('<%s>' % name)
    yield
    print('</%s>' % name)


with tag('h1'):
    print('hello')
    print('world')

with closing(urlopen('https://www.python.org')) as page:
    for line in page:
        print(line)
