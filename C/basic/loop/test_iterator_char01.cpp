#include "string"
#include <iostream>
using namespace std;

int main(int argc, char const *argv[])
{

    string str = "hello world";

    cout << str.length();
    printf("%s", str.c_str());
    
    for (auto &&s : str)
    {
        cout << s;
    }

    return 0;
}
