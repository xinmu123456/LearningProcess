#include <stdio.h>

int main(void)
{
    int a[] = {1, 2, 3};
    int b[] = {4, 5, 6};
    int c[] = {7, 8, 9};
    int *arr[] = {a, b, c};
    int **p = arr;
    printf("%p\n", **p);
    printf("%p", *arr[0]);
    return 0;
}
