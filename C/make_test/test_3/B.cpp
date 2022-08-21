#include "B.h"
#include <iostream>

void B::show() {
    this->A::show();
    printf("show from B\n");
}

B::B() {

}

B::B(int data) : A(data), data_(data){ }

B::B(int data, int select) {

}

void C::show() {
    printf("show from C\n");
}