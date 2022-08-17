#include <iostream>

struct A
{
    int data;
    A() {printf("构造函数调用\n");};
    A(int data) : data(data) {};
    A(A& a) : data(a.data) {printf("拷贝构造函数调用\n");};

    A* return_self(){
        return this;
    }
};

void show(A a){
    printf("data is %d", a.data);
}


int main(int argc, char const *argv[])
{
    A a_1;
    A a_2;
    A a_3;

    std::cout << a_1.return_self() << "\t" << a_2.return_self() << "\t" << a_3.return_self() << std::endl;
    A* a_4 = (A*)malloc(1 * sizeof(A));
    A* a_5 = new A();

    std::cout << a_4 << "\t" << a_5 << std::endl;
    return 0;
}
