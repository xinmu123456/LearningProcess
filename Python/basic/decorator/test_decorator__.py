class Decorators:
    
    def log_function(func):
        def wrapper(*args, **kw):
            print("function start!")
            print(f"args: {args}")
            ret = func(*args, **kw)
            print("function end!")
            return ret
        return wrapper
    
    @log_function
    def func(self):
        pass
    
    log_function = staticmethod(log_function)
    
d = Decorators()
d.func()

@Decorators.log_function
def f():
    pass

@d.log_function
def g():
    pass

f()
g()