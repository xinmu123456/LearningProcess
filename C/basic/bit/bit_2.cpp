#include "stdio.h" 
#include "string.h"

struct kk 
{ 
    unsigned int a:2;
    unsigned int b:3;
    unsigned int c:2;
    unsigned int d:1;
} kt; 

class B {
    mutable int x, y;
    void func() const {
        
    }
};

int main()
{ 
    
    printf("%d\n", sizeof(kk));
    char result = 3; 
    memcpy(&kt, &result, 1); 
    printf("a = %d, b = %d, c = %d, d = %d\n", kt.a, kt.b, kt.c, kt.d); 
    return 1; 
} 