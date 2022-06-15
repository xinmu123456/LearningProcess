import multiprocessing as mp
from multiprocessing import pool


def job(x):
    return x*x


def multicore():
    pool = mp.Pool()
    ret = pool.map(job, range(10))
    print(ret)
    res = pool.apply_async(job, (2,))
    print(res.get())
    multi_res = [pool.apply_async(job, (i,)) for i in range(10)]
    print([res.get() for res in multi_res])


if __name__ == '__main__':
    multicore()
