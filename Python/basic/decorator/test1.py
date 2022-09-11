def log_function(func):
    def wrapper(*args, **kw):
        print("function start!")
        print(f"args: {args}")
        ret = func(*args, **kw)
        return ret
    return wrapper

@log_function
def fib(n):
    if n == 1:
        return 1
    if n == 0:
        return 0
    return fib(n - 1) + fib(n - 2)

print(fib(3))

