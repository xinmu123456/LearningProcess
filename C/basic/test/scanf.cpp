#include <iostream>
#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>

int main(int argc, char const *argv[])
{
    // int i;
    // while (scanf("%d", &i) != EOF) {
    //     printf("%d\n", i);
    // }

    // printf("over\n");
    // fflush(stdout);


    // ------------

    // int i = 89;
    // int x;
    // printf("--------------\n");//输出-----------后不会立即输出89；
    // printf("%d",i);//在这条语句后加上fflush(stdout);则会立即输出89
    // printf("%d",i);//在这条语句后加上fflush(stdout);则会立即输出89
    // printf("%d",i);//在这条语句后加上fflush(stdout);则会立即输出89
    // printf("%d",i);//在这条语句后加上fflush(stdout);则会立即输出89
    // printf("%d",i);//在这条语句后加上fflush(stdout);则会立即输出89
    // fflush(stdout);

    // scanf("%d",&x);//5秒后，遇到scanf时才将89输出到屏幕上。

    //-------------

    // for(int i = 1;i <= 10; i++)     
    // {
    //     printf("%d ",i);
    //     sleep(1);
    // }

    // --------------

    // char ch = getchar();
    // putchar(ch);
    char ch;
    while ((ch = getchar()) != EOF)
    {
        putchar(ch);
        // fflush(stdin);
    }
    
    std::cout << "over" << std::endl;
    puts("yes");
    
    int* arr_p = new int[3];
    int arr[] = {1, 2, 3};
    arr_p = (int *)arr;

    for (int i = 0; i < 3; i++)
    {
        std::cout << (*arr_p);
        // std::cout << (arr_p[i]);
    }
    

    return 0;
}
