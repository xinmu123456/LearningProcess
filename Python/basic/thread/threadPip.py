from multiprocessing import Process, Queue
import os
import time
import random

# 写数据进程的执行代码


def write(q):
    print('Process to write: %s' % os.getpid())
    for value in ['A', 'B', 'C']:
        print('put %s to queue..' % value)
        q.put(value)
        time.sleep(random.random())


# 读数据进程的执行代码
def read(q):
    print('Process to read: %s' % os.getpid())
    while True:
        value = q.get(True)
        print('get %s from queue.' % value)


if __name__ == '__main__':
    # 父进程创建queue, 并且传给各个子进程
    q = Queue()

    pw = Process(target=write, args=(q,))
    pr = Process(target=read, args=(q,))

    #启动子进程, 写入数据
    pw.start()

    #启动子进程, 读取数据
    pr.start()

    # 等待pw结束
    pw.join()

    pr.terminate()
