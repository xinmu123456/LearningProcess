from collections import OrderedDict
l = ['abc', 'ccc', 'aaa']

l.extend([1, 2, 3])
print(l)

l.insert(1, '2')

print(l)

original_list = [80, 10, 50, 18, 3, 50, 8, 18, 9, 8]

print(list(set(original_list)))
print(list(OrderedDict.fromkeys(original_list)))


list1 = [1, 2, 4, 9, 5, 6, 5, 2, 4, 7, 8, 0]
l2 = list(set(list1))
l2.sort(key=list1.index)

print(l2)

d = {1: '123', 2: '122'}
print(list(d))
l3 = [[1, 2], [3, 4]]
print(dict(l3))
l4 = [1, 2, 3]
l5 = [4, 5, 6]
print(tuple(zip(l4, l5)))
print(dict(zip(l4, l5)))
print(list(zip(l4, l5)))
