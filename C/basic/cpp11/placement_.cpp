#include <iostream>

class A
{
private:
    int num;
public:
    A() {printf("A's constructor\n");};
    ~A() {printf("B's destructor\n");};

    void show(){
        printf("num: %d\n", num);
    }
};

int main(int argc, char const *argv[])
{
    char mem[100];

    mem[0] = 'A';
    mem[1] = '\0';
    mem[2] = '\0';
    mem[3] = '\0';
    std::cout << (void*)mem << std::endl;
    A* p = new (mem)A;
    std::cout<< p << std::endl;
    p->show();
    p->~A();
    return 0;
}



