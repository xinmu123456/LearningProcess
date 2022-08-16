#include <iostream>

class A
{
private:

public:
    int a, b, c;
    A(int a, int b, int c): a(a), b(b), c(c)
    {
    }

    A(int a, int b): A(a, b, 0)
    {
        printf("委托构造了\n");
        this->c = 1;
    }
};

int main(int argc, char const *argv[])
{
    A a = A(1, 2, 3);
    A a_ = A(1, 2);

    printf("%d", a_.a);
    return 0;
}
