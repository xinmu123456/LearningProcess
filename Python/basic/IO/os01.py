import os

print(os.name)

print(os.path.abspath('.'))

print(os.environ.get('PATH'))

os.path.join('/Python/basic/IO', 'testdir')

# os.mkdir('./Python/testdir')

# os.rmdir('./Python/testdir')

print(os.path.split('/Users/michael/testdir/file.txt')
      )

print(os.path.splitext('/path/to/file.txt'))

print([x for x in os.listdir('.') if os.path.isfile(
    x) and os.path.splitext(x)[1] == '.py'])
