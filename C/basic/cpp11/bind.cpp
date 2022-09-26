#include <functional>
#include <iostream>

int func(int a, int b, int c, int d, int e){
    std::cout << a << b << c << d << e << std::endl;
    return 0;
}

int main(int argc, char const *argv[])
{
    func(1, 2, 3, 4, 5);

    std::function<int(int, int, int, int, int)> g_ = std::bind(func, std::placeholders::_1, std::placeholders::_3, std::placeholders::_1, 4, 5);
    auto g = std::bind(func, std::placeholders::_1, std::placeholders::_3, std::placeholders::_1, 4, 5);

    g(2, 4, 5);

    return 0;
}
