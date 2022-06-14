def f1(a, b, *args, **kw):
    print('a =', a, 'b =', b, 'args =', args, 'kw =', kw)


f1(1, 2, 3, c=3)
