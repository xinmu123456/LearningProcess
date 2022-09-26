#include <iostream>

using std::cout, std::endl;

class A {
    virtual void eat () {
        printf("eat\n");
    }
};

int main(void) {
    int a = 0;
    int b = 0;
    char c = 'c';

    A __a;

    std::cout << typeid(a).name() << std::endl;
    std::cout << typeid(b).name() << std::endl;
    std::cout << typeid(c).name() << std::endl;
    std::cout << typeid(__a).name() << std::endl;

    if (typeid(a) == typeid (b))
        std::cout << "YES a" << std::endl;
    
    if (typeid(a) == typeid (c))
        std::cout << "YES c" << std::endl;

    A* a_ = new A;
    long long* p = reinterpret_cast<long long*>(a_);
    long long * vp = reinterpret_cast<long long*>(*p);
    typedef void(*fn_p)(void);
    fn_p f = (fn_p)vp[0];
    f();

    // long long * vr = (long long *)(*(vp - 1));
    // long long * vr2 = vr + 3;
    // long long * vr3 = (long long *) (*vr2);
    // const std::type_info* preal = (const std::type_info*)vr3;
    // std::cout << preal->name() << std::endl;

    std::cout << typeid(A).name() << std::endl;
    printf("%d", sizeof(A));


}