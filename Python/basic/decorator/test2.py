class A():
    a = 10
    b = 20
    
    @classmethod
    def fn_1(cls):
        print(cls.a, cls.b)
    
    
print(A.a, A.b)

A.fn_1()