#include<iostream>

int main(int argc, char const *argv[])
{
    int a = 1;
    int* ptr = reinterpret_cast<int*>(a);
    int a_ = reinterpret_cast<long long>(ptr);
    for (int i = 0; i < 400; i++)
    {
        // printf("%d\n", i);
    }
    
    return 0;
}
