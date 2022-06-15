def xo(s: str):
    s1 = s.count('x') + s.count('X')
    s2 = s.count('o') + s.count('O')
    return s1 == s2


s = 'zzpp'
ans = xo(s)
print(ans)
