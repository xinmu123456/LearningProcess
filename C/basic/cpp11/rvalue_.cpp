#include <iostream>

struct A
{
    int a;
    A(int a) : a(a){}
};


int main(int argc, char const *argv[])
{
    A a = {1};
    printf("源值: %d\n", a.a);
    // A* a = (A*)malloc(4);

    int&& temp = std::move(a).a;
    temp = 10;
    printf("右值引用修改后: %d", a.a);

    return 0;
}
