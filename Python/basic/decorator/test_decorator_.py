class Decorators:
    
    @classmethod
    def log_function(cls, func):
        def wrapper(*args, **kw):
            print("function start!")
            print(f"args: {args}")
            ret = func(*args, **kw)
            print("function end!")
            return ret
        return wrapper
    
    @log_function
    def func():
        pass
    
d = Decorators()
Decorators.func()
# d.func()