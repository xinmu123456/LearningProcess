def descending_order(num):

    # turn integer to array
    num = [int(x) for x in str(num)]
    num = sorted(num, reverse=True)
    for i in range(1, len(num)):
        for j in range(0, len(num) - i):
            if num[j] > num[j + 1]:
                num[j], num[j + 1] = num[j], num[j + 1]
    res = 0
    for i in num:
        res = res*10 + i
    return res


if __name__ == '__main__':
    res = descending_order(15)
    print(res, type(res))
