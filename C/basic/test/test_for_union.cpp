#include <iostream>


typedef struct {
    char ch;
    int data;
} st;

union Uon
{
    int data : 1;
    // st s;
    char ch;
};


struct bit_s {
    int data;
    char c_1;
    char c_2;
    char c_3;
    char c_4;
    int data_1;
};


struct S {
    int data;
    int data_;
};

union var 
{
    int data;
    char ch;
    // bit_s bs;
    S s;

    struct S_ {
        int data;
        int data_;
        int data__;
    } s_;

    void func() {
        printf("call\n");
    }
};


union val
{
    int data;
    char ch;
};

const class A {
private:
    int a;
public:
    int data;

    A(int data) : data(data) {
        printf("call of construct\n");
    }

} a = {1};

int main(int argc, char const *argv[])
{
    printf("%d\n", sizeof(val));

    // Uon u;
    // u.data = 10002;
    // printf("%d\n", u);
    // var v;
    // v.data = 1024;
    // v.func();
    
    val v;
    v.data = 0x1234;
    if (v.ch == 0x12)
        printf("大端\n");
    else if (v.ch == 0x34)
        printf("小端\n");
    
    printf("%d", a.data);
}

