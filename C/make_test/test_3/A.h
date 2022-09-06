#ifndef _A_H_
#define _A_H_

#include <iostream>

class A
{
public:
    int data;
    A();
    A(int data);
    ~A();
    virtual void show();
    void eat() {
        printf("eat something\n");
    }
};

#endif