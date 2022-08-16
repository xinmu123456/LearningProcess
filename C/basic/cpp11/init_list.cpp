#include <iostream>

class A
{
public:
    int a, b, c;
    A() : A(0, 0, 0)
    {

    }

    A(int a, int b, int c)
    {
    }



};


class cmp
{
public:
    int operator()(int x, int y)
    {
        return x + y;
    }
};

int fn(int x, int y)
{
    if (x != 0)
        return x + y;
    else if (y == 0)
        return y;
    else
    {
        x = x + 1;
        return x;
    }
}

int main(int argc, char const *argv[])
{
    A a = {1, 2, 3};
    printf("%d\t%d\t%d\n", a.a, a.b, a.c);
    
    auto func = [](int x, int y){return x - y;};
    
    cmp c;
    printf("%d\n", c(1, 2));

    for (const int i : {1, 2, 3, 4, 5})
    {
        printf("%d ", i);
    }
    

    return 0;
}
