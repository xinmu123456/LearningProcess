#include <iostream>

class A {
public:
    int data;

    A () {
        printf("default constructor call from A\n");
    }

    A(int data) : data(data){
        printf("constructor call from A: data is %d\n", this->data);
    }

    A(const A& a) : data(a.data) {
        printf("copy constructor call from A\n");
    }

    A& operator=(const A& a) {
        this->data = a.data;
        printf("assignment func call from A\n");
        return *this;
    }
};

void func(A a) {
    printf("in func\n");
}


int main(int argc, char const *argv[])
{
    
    A a(1);
    // A a_(2);
    // a_ = a; 
    // A a__(a);

    A _a = a;

    a = 1;

    // func(a);

    return 0;
}
