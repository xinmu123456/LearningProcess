#include <iostream>

template <typename F, typename T1, typename T2>
void my_func_temp(F f, T1&& t1, T2&& t2) {
    std::cout << "t1的地址为: " << &t1 << std::endl;
    f(std::forward<T1>(t1), std::forward<T2>(t2));
}

void myfunc(int&& v1, int& v2) {
    std::cout << "v1的地址为: " << &v1 << std::endl;
    ++v2;
    std::cout << "v1 + v2 = " << v1 + v2 << std::endl;
}

int main(int argc, char const *argv[])
{
    int j = 70;
    my_func_temp(myfunc, 20, j);
    std::cout << "j = " << j << std::endl;
    return 0;
}
