#include <iostream>

struct A
{
    int a;
    // A(int a) : a(a) {printf("call from construct A\n");} 
    void* operator new(std::size_t t)
    {
        printf("call from new \n");
        return malloc(t);
    }
};

int main(int argc, char const *argv[])
{
    A* a = (A*)malloc(1 * sizeof(A));
    // A* a_ = new A(1);
    a->a = 10;
    printf("%d", a->a);
    return 0;
}
