#ifndef ADD_HPP
#define ADD_HPP

#include <iostream>
#include "show.hpp"

int add(int a, int b){
    show();
    printf("call from add\n");
    return a + b;
}

#endif