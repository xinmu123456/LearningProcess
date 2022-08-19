#include <iostream>
#define setbit(x, y) x |= (1 << y)
#define clrbit(x, y) x &= ~(1 << y)
#define getbit(x, y) x = (x >> y) & 1

int main(int argc, char const *argv[])
{
    uint8_t x = 0b00000000;
    setbit(x, 2);
    setbit(x, 3);
    clrbit(x, 2);

    printf("%d %d\n", getbit(x, 2), getbit(x, 3));
    printf("%d\n", x);
    return 0;
}
