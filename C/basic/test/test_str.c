#include <stdio.h>
#include <string.h>

int sum(int arr[3]){
    return arr[0] + arr[1] + arr[2];
}

int main(int argc, char const *argv[])
{
    const char* str1 = "hello, world";

    char chs[100];

    // char* str2 = (char[10]){1, 2, 3};
    char* str2 = chs;

    strcpy(str2, str1);

    printf("%s\n", str2);

    // printf("%d\n", sum((int []){1, 2, 3}));

    // (int []) {1, 2, 3}[0] == 2;

    return 0;
}
