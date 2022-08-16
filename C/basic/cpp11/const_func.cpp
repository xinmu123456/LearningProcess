#include <iostream>
#include <functional>
using std::function;

int add(int x, int y)
{
    return x + y;
}

class Stu
{
public:
    int age, id;
    Stu(int age, int id) : age(age), id(id) {}; 
    void amend_age(int age) const {
        
    }

    void alter_age(int age) 
    {
        this->age = age;
    }
};



int main(int argc, char const *argv[])
{
    int (*func)(int, int) = add;
    function<int(int, int)> fn = add;




    return 0;
}
