import multiprocessing as mp


def job(q: mp.Queue):
    ret = 0
    for i in range(1000):
        ret += i + i**2 + i**3
    q.put(ret)


if __name__ == '__main__':
    q = mp.Queue()
    p1 = mp.Process(target=job, args=(q,))
    p2 = mp.Process(target=job, args=(q,))
    p1.start()
    p2.start()
    p1.join()
    p2.join()
    ret1, ret2 = q.get(), q.get()
    print(ret1 + ret2, ret1, ret2)
