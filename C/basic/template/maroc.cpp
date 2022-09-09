#include <iostream>
#define A (2)
#define _STR(s) #s
#define STR(s) _STR(s)  // 转换宏
#define _CONS(a, b) int(a##e##b)
#define CONS(a, b) _CONS(a, b) // 转换宏
#include <string.h>
#include <climits>
#define _DECLARE_S_(name) struct name##_ {\
    int data;\
}


_DECLARE_S_(abc);

int main(void)
{
    int i = 12312;
    
    printf("%d\n", i);
    memset(&i, 255, sizeof(i));
    printf("%d\n", i);

    
    int j = 121;
    memcpy(&j, &i, sizeof(i));
    printf("%d\n", j);


    // printf("int max: %s\n", STR(INT_MAX));  //INT_MAX,int型的最大值,为一个变量, 需要#include<climits>

    // printf("%d\n", CONS(2, 2));

    typedef int* PINT;
    PINT a, b;
    printf("%d\n", sizeof(a));

}