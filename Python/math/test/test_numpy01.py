import numpy as np

print(np.array([1, 2, 3, 4, 5]))

a = np.zeros((3, 2))
print(a, a.shape)

a = np.ones((3, 2))
print(a, a.shape)

print(np.arange(3, 7))

print(np.linspace(0, 1, 5))


print(np.random.rand(2, 4))

a = np.zeros((4, 2), dtype=np.int32)
print(a)

a = np.array([1, 2, 3, 4, 5])
print(a.min(), a.max())
print(a.argmin(), a.argmax())

a = np.array([1, 2, 3])
b = np.array([4, 5, 6])

print(a + b)
print(a / b)

a = np.array([[1, 2], [3, 4]])
b = np.array([[2, 0], [0, 2]])

print(a @ b)

a = np.array([1, 2, 3])
print(np.sqrt(a), np.sin(a))

a = np.array([1, 2, 3, 4, 5])

print(a.var(), a.std())

a = np.array([[1, 2, 3, 4, 5],
              [5, 6, 7, 8, 9]])
print(a.sum(axis=0), a.sum(axis=1))


a = np.array([[1, 2, 3], [4, 5, 6]])
print(a[0, 1])

a = np.arange(10)
print(a)
print(a[(a > 3) & (a % 2 == 0)])

a = np.array([[1, 2, 3], [4, 5, 6]])
print(a[0, 0:2])
print(a[0])
print(a[0, :])
