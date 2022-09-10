#include <iostream>

class A {
public:
    int data;
    static int flag;
    void func_1() {

    }

    static void func_2();

};

int A::flag = 1;

void A::func_2() {
    printf("hello\n");
}

int main(void){
    A a;
    // int A::flag = 1;
    // A::flag = 2;
    a.flag = 2; 
    // A::data;
    // A::func_1();
    A::func_2();
}