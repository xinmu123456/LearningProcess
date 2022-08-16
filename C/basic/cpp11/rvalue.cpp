#include <iostream>

class A
{
public:
    int a;
    A(int a) : a(a) {printf("普通构造函数调用\n");};
    A(const A& a) : a(a.a) {printf("拷贝构造函数调用\n");}// 拷贝构造
    A(A&& a) : a(std::move(a.a)) {printf("移动构造函数调用\n");}; // 移动构造
};



int main(int argc, char const *argv[])
{
    A a = A(1);
    A a_ = a;
    A a__ = A(a);
    A a___ = std::move(a);
    A _a = {1};
    A&& __a = std::move(a);

    return 0;
}
