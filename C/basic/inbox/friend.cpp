#include <iostream>

class A
{
    friend class B; // 类做友元
    friend void show_A(A& a); // 全局函数做友元
    // friend void C::visit_A(A& a); // 成员函数做友元
private:
    int data;
public:
    A() = default;
    explicit A(int data) : data(data) {};
};

class B
{
public:
    void show_friend(A& a){
        printf("%d\n", a.data);
    }
};

class C
{
public:
    void visit_A(A& a){
        // printf("%d\n", a.data);
    }
};

void show_A(A& a){
    printf("%d\n", a.data);
}

int main(int argc, char const *argv[])
{
    A a(1);
    B b;
    b.show_friend(a);
    return 0;
}
