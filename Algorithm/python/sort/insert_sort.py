def insert_sort(arr):
    for i in range(1, len(arr)):
        preIndex = i - 1
        current = arr[i]
        while preIndex >= 0 and arr[preIndex] > current:
            arr[preIndex + 1] = arr[preIndex]
            preIndex -= 1
        arr[preIndex + 1] = current

    return arr


arr = insert_sort([1, 3, 4, 6, 2, 3])

print(arr)


def insert_sort(arr):
    for i in range(1, len(arr)):
        pre = i - 1
        curVal = arr[i]
        while pre >= 0 and arr[pre] > curVal:
            arr[pre + 1] = arr[pre]
            pre = pre - 1
        arr[pre + 1] = curVal
    return arr


arr = insert_sort([1, 3, 4, 6, 2, 3])
