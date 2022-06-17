class A:
    def say(self):
        print("A")


class B(A):
    def say(self):
        print('B')


class M(B):
    pass


m = M()
m.say()

########################################


class A:
    def say(self):
        print("A")


class B:
    def say(self):
        print('B')


class M(A, B):
    pass


m = M()
m.say()

########################################


class A:
    def say(self):
        print("A")


class B:
    def say(self):
        print('B')


class C(A):
    pass


class M(C, B):
    pass


m = M()
print(M.mro())
m.say()

####################################


class A:
    def say(self):
        print("A")


class B(A):
    def say(self):
        print('B')


class C(A):
    pass


class M(C, B):
    pass


m = M()
print(M.mro())
m.say()
