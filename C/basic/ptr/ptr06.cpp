#include <stdio.h>

int main(void)
{

    int arr[2][3] = {1, 2, 3, 4, 5, 6};
    printf("%d\n", **arr);
    printf("%d\n", **(arr + 1));

    char *arg1 = "abc";
    printf("%c", *arg1);

    char *arg2[] = {"abc", "def"};
    printf("%s", **arg2);

    return 0;
}