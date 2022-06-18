#include <stdio.h>

int main()
{
    int arr1[] = {1, 2, 3, 4};
    printf("%d\n", *(arr1 + 1));
    int arr[3][5] = {{01, 02, 03, 04, 05},
                     {11, 12, 13, 14, 15},
                     {21, 22, 23, 24, 25}};
    int *p1 = arr[0];
    printf("%d\n", *p1);

    int *p2 = nullptr;
    for (p2 = arr[0]; p2 < arr[0] + 15; p2++)
    {
        printf("%x->%d\n", p2, *p2);
    }

    return 0;
}