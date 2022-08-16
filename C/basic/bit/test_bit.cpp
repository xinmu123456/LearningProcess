#include <iostream>

uint8_t u;

int main(int argc, char const *argv[])
{
    u = (0b11111111);
    u >>= 7;
    printf("%d\n", u);

    //-------------
    u = 1;
    u <<= 7;
    printf("%d\n", u);

    //-------------
    u = 0;
    u = ~u;
    printf("%d\n", u);

    //-------------
    u = 0;
    u |= (0b11111111);
    printf("%d\n", u);

    //------------
    u = 0b11111111;
    u &= 0;
    printf("%d\n", u);

    u = 0b11111111;
    u ^= 0;
    printf("%d\n", u);
}