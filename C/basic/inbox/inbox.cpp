#include <iostream>
#include <string.h>

int main(int argc, char const *argv[])
{
    const char* s = "Hello\0Hi";

    std::cout << strlen(s) << " " << sizeof(s);

    constexpr const int N = 5;
    constexpr int N_ = 5;
    static constexpr int N__ = 5;

    int a = 5.2;
    int a_(5.2);
    // int a__ {5.2}; //error
    auto a___ = int(5.2);

    return 0;
}
