#include <iostream>
using namespace std;

class A {

};

int main(int argc, char const *argv[])
{
    // double a = 1.222;
    // int b = static_cast<double>(a);


    // int i = 0;
    // void* vp = &i;
    // int* ptr = static_cast<int*>(vp);
    // *ptr = 3;
    // printf("%d", i);

    // int i = 256;
    // void* vp = &i;
    // char* p = static_cast<char*>(vp);
    // *p = 4;
    // printf("%d", i);

    // const int a = 10;
    // const int* pointer_const = &a;
    // int* b = const_cast<int*>(pointer_const);
    // *b = 20;
    // cout << "b = " << *b << endl;
    // cout << "a = " << a << endl;
    // cout << "b = " << b << endl;
    // cout << "&a = " << &a << endl;

    cout<<"请输入一个数："<<endl;
    int input;
    cin>>input;
    const int a = input;
    const int*pointer_const = &a;
    int*b = const_cast<int*>(pointer_const);
    *b = 20;
    cout << "b = " << *b << endl;
    cout << "a = " << a << endl;
    cout << "b = " << b << endl;
    cout << "&a = " << &a << endl;


    return 0;
}