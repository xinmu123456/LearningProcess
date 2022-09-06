#include <iostream>

int main(int argc, char const *argv[])
{
    int a = 0;

    a ++;
    double ret;
    ret = (double)a / 5 * 100;
    printf("%.2f", ret);

    return 0;
}
