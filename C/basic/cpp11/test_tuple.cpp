#include <tuple>
#include <iostream>
#include <string>
using std::tuple;

int add(int x, int y)
{
    return x + y;
}

class B {

};
class A
{
public:
    B& b;
    A(B& b) : b(b){}
    ~A() {}
};

int main(int argc, char const *argv[])
{

    tuple<int, char> t(2, 'x');
    int size = std::tuple_size<decltype(t)>::value;
    printf("%d\n", size);

    printf("%d\n", std::get<0>(t));

    auto _t = std::make_tuple(1, 'a');
    printf("%d\n", std::get<0>(_t));

    int (*func)(int, int) = add;
    int ans = (*func)(1, 2);
    printf("%d\n", ans);

    std::string str = "a" "v\n";
    printf("%s", str.c_str());
    std::cout << str << std::endl;

    B b;
    A a = {b};

    return 0;
}
