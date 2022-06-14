class A:
    @staticmethod
    def f1(x):
        print(x)

    @classmethod
    def f2(cls, x):
        print(cls, x)


A.f1(1)
A.f2(1)

print(A.__dict__)
