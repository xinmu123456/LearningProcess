#include <iostream>
using namespace std;

class T
{
public:
    T() { cout << "constructor" << endl; }
    ~T() { cout << "destructor" << endl; }
};

int main()
{
    const int NUM = 3;

    T *p1 = new T[NUM];
    cout << hex << p1 << endl; //输出P1的地址
    // delete[] p1;
    delete p1;

    cout << endl;

    T *p2 = new T[NUM];
    cout << p2 << endl; //输出P2的地址
    delete[] p2;

    return 0;
}