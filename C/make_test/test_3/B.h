#ifndef _B_H_
#define _B_H_

#include "A.h"
#include <iostream>

class B : public A {
public:
    int data_;
    B();
    B (int data);
    B (int data, int select);
    virtual void show() override;
};

class C : public A {
public:
    virtual void show() override;
};

#endif