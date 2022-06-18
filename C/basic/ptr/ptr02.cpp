#include <stdio.h>

int main(void)
{

    int a[3][4] = {{0, 1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10, 11}};
    printf("%d\n", a[1][1]);
    int(*p)[4] = a;
    printf("%d", *(p[2] + 1));

    return 0;
}