from time import time


def log_func(msg: str):
    print(f"log_func msg: {msg}")
    def decorator(func):
        print("outer decorator active")
        def wrapper(*args, **kw):
            print("inner decorator active")
            print(f"func args: {args}")
            ret = func(*args, **kw)
            print("func over")
            return ret
        print("outer decorator over")
        return wrapper
    return decorator

# @log_func("add func")
# def add(a, b):
#     return a + b

# print(add(1, 2))
# log_func("add func")(add)(1, 2)

# def add(a, b):
    # return a + b

# log_func("add func")(add)(1, 2)

def time_cal(msg: str):
    print("outer msg: %s %s" %(msg, msg))
    def decorator(func):
        print("timer start")
        def wrapper(*args, **kw):
            start = time()
            ret = func(*args, **kw)
            print(f"cast time {time() - start}")
            return ret
        print("timer end")
        return wrapper
    return decorator
            

@time_cal('calculate 10000')
def calculate(n):
    sum = 0
    for i in range(n):
        sum += i
    return sum

calculate(10000)