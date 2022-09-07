#include <iostream>

int main(int argc, char const *argv[])
{
    int n;
    while(std::cin >> n) // 当输入EOF会中止
        std::cout << n << std::endl;
    return 0;
}
