#include <iostream>

int main(int argc, char const *argv[])
{
    int x, y, z;
    x = y = 1;
    z = (x ++, y ++, ++ y);

    printf("%d, %d, %d\n", x, y, z);

    return 0;
}
