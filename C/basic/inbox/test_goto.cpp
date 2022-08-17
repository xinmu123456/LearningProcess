#include <iostream>

class A {
public:
    virtual void get(){}
}; 

class B : public A{
public:
    virtual void get() override
    {

    }
};

class C : public B{

    // void temp() override{
    //     get();
    // }

    void get(){};
};


int main(int argc, char const *argv[])
{
    
    printf("%d", 1);
    goto jump;
    printf("%d", 2);
    printf("%d", 3);
jump:
    printf("%d", 4);

    return 0;
}
