#include <tuple>
#include <iostream>
using std::tuple;

int main(int argc, char const *argv[])
{

    tuple<int, char> t(2, 'x');
    int size = std::tuple_size<decltype(t)>::value;
    printf("%d\n", size);

    printf("%d\n", std::get<0>(t));

    auto _t = std::make_tuple(1, 'a');
    printf("%d", std::get<0>(_t));

    return 0;
}
