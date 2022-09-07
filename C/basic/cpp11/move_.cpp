#include <iostream>

class B{

};

class A
{
public:
    B* pb;

    A() : pb(new B()){
        printf("类A的构造函数执行, 构造产生的对象的地址是%x\n", this);
    }

    A(const A& tmpa) : pb(new B(*(tmpa.pb))){
        std::cout << "类A的拷贝构造函数执行了, 拷贝构造生成的副本的地址是" << this << std::endl;
    }

    A(A&& tmpa) {
        pb = tmpa.pb; 
        tmpa.pb = nullptr; // 手动置空, 防止野指针
        std::cout << "类A的移动构造函数执行了, 移动构造产生的对象的地址是" << this << std::endl;
    }

    ~A() {
        delete pb; 
        std::cout << "类A的析构函数执行, 析构对象的地址是" << this << std::endl; 
    }
};

A getA(){
    A a;
    return a;
}

int main(int argc, char const *argv[])
{
    A peach = getA();
    A a = std::move(peach);
    return 0;
}
