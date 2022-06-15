def int2arr(num: int):
    l = []
    for i in str(num):
        l.append(int(i))
    return l


if __name__ == '__main__':
    print(int2arr(123))
    print(type(int2arr(123)))
