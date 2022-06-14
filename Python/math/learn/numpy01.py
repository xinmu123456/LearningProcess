import numpy as np

arr = np.array([1, 2, 3])

print(arr)

arr = np.array([[1, 2], [3, 4]])
print(arr)

arr = np.array([1, 2, 3], ndmin=2)
print(arr)

arr = np.array([1, 2, 3], dtype=complex)
print(arr)
