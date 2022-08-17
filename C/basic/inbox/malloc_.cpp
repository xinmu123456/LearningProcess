#include <iostream>
#include <string.h>

struct A
{
    int data;
};

int main(int argc, char const *argv[])
{
    A* a = (A*)malloc(1 * sizeof(A));
    a->data = 0; // 这里如果不初始化就会是乱的
    printf("%d %d\n", sizeof(A), a->data);
    free(a);

    A* a_ = (A*)calloc(1, sizeof(A)); // 第一个参数为所申请的类型的数量, 第二个参数是该类型所占大小, calloc会将申请的内存全部初始化为0, 所以下面打印0
    printf("%d\n", a_->data);
    free(a_);

    A* _a = (A*)alloca(1 * sizeof(A)); // alloca 向栈上申请内存, 不需要手动释放
    printf("%d\n", _a->data);

    A* a__ = (A*)realloc(malloc(sizeof(A)), 2 * sizeof(A)); // realloc 向指定的首地址重新分配内存空间, 第一个参数是要给哪重新分配, 第二个参数是要分配的大小
    free(a__);

    A* __a = (A*)malloc(1 * sizeof(A));
    memset(__a, 0b00000000, sizeof(A)); //memset初始化内存, 第一个参数是内存首地址, 第二个是每个byte要被初始化成什么, 第三个是要初始化的byte的大小
    printf("%d\n", __a->data);
    free(__a);

    return 0;
}
