import threading
import time


def thread_job():
    print('t1 start \n')
    for i in range(10):
        print(i, end='')
        time.sleep(0.1)
    print('\nt1 finished \n')


def t2_job():
    print('t2 start\n')
    print('t2 finish\n')


def main():
    added_thread = threading.Thread(target=thread_job, name='t1')
    added_thread.start()
    # added_thread.join()
    thread2 = threading.Thread(target=t2_job, name='t2')
    thread2.start()
    thread2.join()
    added_thread.join()

    print('all done\n')


if __name__ == '__main__':
    main()
