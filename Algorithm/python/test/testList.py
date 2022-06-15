l = [3, 2, 3]

for i in l:
    print(i)

f1 = f2 = f3 = '1'

print(f1, f2, f3)

print(*l)

lst = [1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5]
s = set(lst)
print(s)

print(lst.__iter__)

for i in s:
    count = lst.count(i)
    print(i, '出现的次数为:', count)
