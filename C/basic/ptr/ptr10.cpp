#include <iostream>

int main(int argc, char const *argv[])
{
    int a = 0, b = 0, c = 0, d = 0;

    //---普通指针
    int* ptr_1 = &a;
    *(ptr_1) = 1;   // 可修改指向内容
    ptr_1 = &b;     // 可修改指向地址

    //---常量指针
    const int* ptr_2 = &b;
    *(ptr_2) = 2;   // error 不可修改指向内容
    ptr_2 = &a;     // 可以修改指向地址

    //---指针常量
    int* const ptr_3 = &c;
    *(ptr_3) = 3;   // 可以修改指向内容
    ptr_3 = &d;     // error 不可修改指向地址

    //---常指针
    const int* const ptr_4 = &d;
    *(ptr_4) = 4;   // error 不可修改指向内容
    ptr_4 = &a;     // error 不可修改指向地址


    return 0;
}
