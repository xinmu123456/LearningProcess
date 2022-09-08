#include <stdio.h>

int add(int a, int b){
    return a + b;
}

// int add(int a) { // c语言不支持函数的重载
//     return a;
// }

void show(int arr[5][5]){

    for(int i = 0; i < 5; i ++)
        for(int j = 0; j < 5; j ++)
            printf("%d ", arr[i][j]);

}

int main(int argc, char **argv)
{
    
    int arr[5][5] = {0};
    // show(arr);
    // argv = argv + 1;
    for (int i = 0; i < argc; i++)
    {
        printf("%s\n", argv[i]);
        printf("%x\n", argv);
        argv = argv + 1;
        printf("%x\n", argv);

    }
    
    return 0;
}
