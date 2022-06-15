import multiprocessing as mp
import threading as td
import time
from typing import Callable


def time_count(func: Callable):
    def wrapper(*args, **kwargs):
        st = time.time()
        func(*args, **kwargs)
        print(f"func: {func.__name__} takes {time.time() - st} ")
    return wrapper

def job(q: mp.Queue):
    ret = 0
    for i in range(1000000):
        ret += i + i**2 + i**3
    q.put(ret)

@time_count
def multicore():
    q = mp.Queue()
    p1 = mp.Process(target=job, args=(q,))
    p2 = mp.Process(target=job, args=(q,))
    p1.start()
    p2.start()
    p1.join()
    p2.join()
    ret1, ret2 = q.get(), q.get()
    print('core', ret1 + ret2, ret1, ret2)

@time_count
def normal():
    ret = 0
    for _ in range(2):
        for i in range(1000000):
            ret += i + i**2 + i**3
    print('normal:', ret)

@time_count
def multithread():
    q = mp.Queue()
    t1 = td.Thread(target=job, args=(q,))
    t2 = td.Thread(target=job, args=(q,))
    t1.start()
    t2.start()
    t1.join()
    t2.join()
    ret1, ret2 = q.get(), q.get()
    print('thread', ret1 + ret2, ret1, ret2)




if __name__ == '__main__':
    normal()
    multicore()
    multithread()
    