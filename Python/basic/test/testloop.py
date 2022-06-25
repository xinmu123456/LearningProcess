for i in range(10):
    if i == 2:
        i = i + 1
        continue
    print(i, type(i))

i = 0

while i < 10:
    if i == 2:
        i = i + 2
        continue
    print(i)
    i += 1

print([i for i in range(10) if i % 2 == 0])
print([i if i % 2 == 0 else -i for i in range(10) if i % 2 == 0])
