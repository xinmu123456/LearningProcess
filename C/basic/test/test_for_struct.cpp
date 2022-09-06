#include <iostream>

struct A
{
    int data:32;
    int other;
    unsigned int bit_data:1;
};



int main(int argc, char const *argv[])
{
    A _a;
    A a = {.data = 10, .other = 11}; // 无序赋值
    A a_ = {data : 10, other : 20}; // 有序赋值
    printf("%d %d\n", a_.data, a_.other);

    a.bit_data = 1;
    printf("%d", a.bit_data);

    return 0;
}
