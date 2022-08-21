#include <iostream>
#include "add.hpp"
#include "show.hpp"

int main(int argc, char const *argv[])
{
    add(1, 2);

    printf("from main\n");
    return 0;
}
