#include <iostream>
using std::string;

int main(int argc, char const *argv[])
{
    string str;
    int i = 0;
    while (std::cin >> str)
    {
        std::cout << str << std::endl;
        std::cout << ++i << std::endl;
    }
    
    return 0;
}
