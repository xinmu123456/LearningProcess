import threading
import time


def my_thread(index):
    for _ in range(5):
        print(f"print from thread {index}")


if __name__ == '__main__':
    for index in range(3):
        thread = threading.Thread(target=my_thread, args=(index,))
        thread.start()
