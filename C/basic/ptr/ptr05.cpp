#include <stdio.h>

int main(void)
{
    int arr[5] = {1, 2, 3, 4, 5};
    int(*p1)[5] = &arr;
    printf("%x, %d\n", p1, **p1);
    int arr1[2][2] = {{1, 2}, {3, 4}};
    int(*p2)[2] = arr1;
    printf("%x, %d", p2, *(*(p2) + 1));

    return 0;
}