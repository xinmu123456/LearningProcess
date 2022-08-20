#include <iostream>

class A
{
private:
    int data;
public:
    A(int i) : data(i){}
    ~A() {}
    A(A& a): data(a.data){printf("拷贝构造函数调用\n");}

    A return_obj(){
        return *this;
    }

    A& return_ref(){
        // A temp{1};
        return *this;
    }

    void show_addr() const {
        std::cout << this << std::endl;
    }
};


int main(int argc, char const *argv[])
{
    
    A a{1};
    A a_ = a.return_obj();
    // A& a__ = a.return_ref();
    a_.show_addr();
    a.show_addr();


    return 0;
}
