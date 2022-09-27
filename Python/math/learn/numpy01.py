import numpy as np

arr = np.array([1, 2, 3])

print(arr)

arr = np.array([[1, 2], [3, 4]])
print(arr)

arr = np.array([1, 2, 3], ndmin=2)
print(arr)

arr = np.array([1, 2, 3], dtype=complex)
print(arr)


# [i * 1000 + m * 100 for m in range(100) for i in range(1000)]
import time

time.localtime()

a = [1, 2, 3]

l = [f'{i} & {j}' for i in a for j in range(i)]
print(l)

l = []
for i in a:
    for j in range(i):
        l.append(f'{i} & {j}')
print(l)
        