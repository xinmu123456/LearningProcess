def bubble_sort(arr):
    for i in range(1, len(arr)):
        for j in range(len(arr) - i):
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
    return arr


arr = bubble_sort([1, 2, 3, 5, 3, 1])
print(arr)
