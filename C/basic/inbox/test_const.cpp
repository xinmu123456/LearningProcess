#include <iostream>

class A {
public:
    void func_1() const {

    }

    void func_2() const & {
        
    }

    void func_3() const && {

    }

    void func_4() & {

    }

    void func_5() && {

    }

    void func_6(){

    }

    A() = default;
    A (A&& a){
        printf("拷贝调用");
    }
};


int main(int argc, char const *argv[])
{
    const int i = 10;
    int const j = 10;

    A a; // 左值a
    a.func_1();
    a.func_2();
    a.func_3(); // 左值对象不能调用常右值成员函数
    a.func_4();
    a.func_5(); // 左值对象不能调用右值成员函数
    a.func_6();

    const A a_ = A(); // 常量左值对象a
    a_.func_1();
    a_.func_2();
    a_.func_3(); // 常量对象不能调用常右值成员函数
    a_.func_4(); // 常量对象不能调用左值成员函数
    a_.func_5(); // 常量对象不能调用右值成员函数
    a_.func_6(); // 常量对象不能调用普通成员函数

    std::move(a).func_1();
    std::move(a).func_2();
    std::move(a).func_3();
    std::move(a).func_4(); // 右值对象不能调用左值方法
    std::move(a).func_5();
    std::move(a).func_6();


    A&& _a = std::move(a); // 右值引用
    _a.func_1();
    _a.func_2();
    _a.func_3();
    _a.func_4();
    _a.func_5();
    _a.func_6();

    return 0;
}
