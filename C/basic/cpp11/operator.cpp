#include <iostream>
using std::ostream;

struct A
{
    int data;
    friend ostream& operator<< (ostream& cout, A& a);
    ostream& operator<< (ostream& cout)
    {
        cout << this->data << std::endl;
        return cout;
    }


};

ostream& operator<< (ostream& cout, A& a)
{
    cout << a.data << std::endl;
    return cout;
}


int main(int argc, char const *argv[])
{
    A a;
    a.data = 1;
    // std::cout << a;
    a.operator<<(std::cout);
    std::cout << a;
    return 0;
}
