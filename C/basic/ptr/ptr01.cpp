#include <stdio.h>

int main(void)
{
    char c = 'A';
    int a = 100;
    printf("a = %d\n", a);
    printf("&a = %x\n", &a);

    printf("c = %d\n", c);
    printf("&c = %x\n", &c);

    int *p1 = &a;
    char *p2 = &c;

    printf("p1 = %d\n", *p1);
    printf("p2 = %c", *p2);
    return 0;
}