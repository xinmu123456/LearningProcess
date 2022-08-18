#include <iostream>
using std::cout, std::endl;

template <typename T>
void show(T&& what){
    cout << what << " and it is a rvalue" << endl;
}

template <typename T>
void show(T& what){
    cout << what << " and it is a lvalue" << endl;
}

template <typename T, typename U>
void set(T&& data_1, U&& data_2)
{
    show(std::forward<T>(data_1));
    show(std::forward<U>(data_2));
}

int main(int argc, char const *argv[])
{
    int a = 1;
    set(a, 2);
    return 0;
}
