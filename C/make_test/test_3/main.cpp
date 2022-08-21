#include "calculator.h"
#include "B.h"
#include "A.h"

int main(int argc, char const *argv[])
{
    B b(1);
    b.show();
    b.eat();
    C c;
    c.show();
    add(1, 2);
    return 0;
}
