import multiprocessing
import os

print(os.getpid())


def f():
    print(os.getpid())


class MyProcess(multiprocessing.Process):
    def run(self):
        f()


# p = MyProcess()
# p.start()
# p.join()

if __name__ == '__main__':
    p = multiprocessing.Process(target=f)
    p.start()
    p.join()
