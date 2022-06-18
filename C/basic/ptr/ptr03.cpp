#include <stdio.h>

int main()
{
    char c = 'c';
    int a = 1;
    int *p = &a;
    printf("%d, %d\n", *p, a);
    *p = 2;
    printf("%d, %d", *p, a);

    int *pi;
    int arr[10];
    pi = arr;

    return 0;
}