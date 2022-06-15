def find_it(seq):
    for i in seq:
        if seq.count(i) % 2 != 0:
            return i


l = [1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5]
ans = find_it(l)
print(ans)
