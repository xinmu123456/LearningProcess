#include <stdio.h>

int main(void)
{
    int arr[] = {1, 2, 3, 4, 5};
    int *p = arr;
    printf("p->%d\n", *(p + 1));

    int *p1 = arr;
    for (int i = 0; i < sizeof(arr) / sizeof(arr[0]); i++)
    {
        printf("%x -> %d\n", p1, *p1);
        p1++;
    }

    return 0;
}