#include <iostream>
#include <memory>

class A
{
public:
    int a;
    A(int a) : a(a){}

    ~A() {printf("析构\n");}
};

int main(int argc, char const *argv[])
{
    {
        std::shared_ptr<A> p1(new A(1));
        std::shared_ptr<A> p2(std::move(p1));
        std::shared_ptr<A> p3(p2);
        std::shared_ptr<A> p4 = std::make_shared<A>(1);
        // std::cout << p1->a << std::endl;
        printf("%d\n", p4->a);
        // printf("%d\n", p2.use_count());
    }

    printf("outside\n");


    return 0;
}