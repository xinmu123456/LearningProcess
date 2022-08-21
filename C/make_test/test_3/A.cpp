#include "A.h"
#include "iostream"

A::A(int data) : data (data) {printf("data构造\n");};

A::~A() = default;

A::A() = default;

void A::show() {
    printf("show from A\n");
}