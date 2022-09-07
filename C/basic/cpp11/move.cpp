#include <iostream>

class A
{
private:
    /* data */
public:
    A() {
        std::cout << "调用类A的构造函数" << std::endl;
        std::cout << "该对象的地址是" << this << std::endl;

    }
    ~A() {
        std::cout << "调用类A的析构函数" << std::endl;
    }
};

int main(int argc, char const *argv[])
{
    A apple;
    std::cout << &apple << std::endl;
    return 0;
}
