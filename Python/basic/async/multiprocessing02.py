from ast import arg
import multiprocessing as mp
import threading as td


def job(a, b):
    print(f"something about {a + b}")


if __name__ == '__main__':
    a, b = 1, 2

    t1 = td.Thread(target=job, args=(a, b))
    p1 = mp.Process(target=job, args=(1, 2))

    t1.start()
    p1.start()
    t1.join()
    p1.join()
