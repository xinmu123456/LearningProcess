
class MetaA(type):
    pass


class A(metaclass=MetaA):
    pass

print(A.__base__)

class Singleton(type):
    """
    单例模式
    """
    def __init__(cls, *args, **kwargs):
        cls.__instance = None
        super().__init__(*args, **kwargs)

    def __call__(cls, *args, **kwargs):
        if cls.__instance is None:
            cls.__instance = super().__call__(*args, **kwargs)
        return cls.__instance


class Test(metaclass=Singleton):

    def __init__(self):
        pass


a = Test()
b = Test()
print(id(a))
print(id(b))
