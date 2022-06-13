

from concurrent.futures import ThreadPoolExecutor
from multiprocessing.pool import ThreadPool
import time


def func(value):
    time.sleep(1)
    print(value)
    return 123


# 创建线程池
pool = ThreadPoolExecutor(max_workers=5)

for i in range(10):
    fut = pool.submit(func, i)
    print(fut)
