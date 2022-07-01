#include "stdio.h"
using namespace std;

int main(int argc, char const *argv[])
{

    // int a = 5;
    // // 5 = a;

    // int b = 10;
    // a = b;

    int num = 10;
    int &b = num;
    // int& c = 10; 报错
    const int &c = 10;

    // int&& a = num; 右值引用不能初始化为左值
    int &&a = 10;

    a = 11;
    printf("%d", a);

    return 0;
}
