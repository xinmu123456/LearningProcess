class Decorators:
    def log_function_1(self, func):
        def wrapper(*args, **kw):
            print("function start!")
            print(f"args: {args}")
            ret = func(*args, **kw)
            print("function end!")
            return ret
        return wrapper
    
    @classmethod
    def log_function_2(cls, func):
        def wrapper(*args, **kw):
            print("function start!")
            print(f"args: {args}")
            ret = func(*args, **kw)
            print("function end!")
            return ret
        return wrapper
    
    @staticmethod
    def log_function_3(func):
        def wrapper(*args, **kw):
            print("function start!")
            print(f"args: {args}")
            ret = func(*args, **kw)
            print("function end!")
            return ret
        return wrapper
    
    
    
    
d = Decorators()

@d.log_function_1
def add(a, b):
    return a + b 

@Decorators.log_function_2
def sub(a, b):
    return a - b

@Decorators.log_function_3
def dev(a, b):
    return a / b

# add(1, 2)
# sub(1, 2)
dev(2, 1)