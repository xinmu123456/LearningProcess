#include <cstdio>

int fn(int x, int y) {
    return x + y;
}

int fn_1(){
    return 1;
}

int fn_2(){
    return 2;
}

int fn_3(){
    return 3;
}

int main(void) {
    // int a = 1, b = 2, c = 3, d = 4, e = 4;
    // int* pa = &a, *pb = &b, *pc = &c, *pd = &d, *pe = &e;

    // int* v[5] = {pa, pb, pc, pd, pe};
    // v[0] = &a;

    // int (*v)[5];

    // int arr[5] = {a, b, c, d, e};
    // v = &arr;

    // printf("%d\n", (*v)[1]);

    // int (*fp)(int, int);
    // fp = fn;

    // int (*v[3])() = {fn_1, fn_2, fn_3};
    
    // v[0] = &fn_1;
    // v[1] = fn_2;

    // printf("%d %d\n", v[0](), (*v[1])());

    // int (*fn_arr[3])() = {fn_1, fn_2, fn_3};

    // int (*(*v)[])();

    // v = &fn_arr;

    // printf("%d\n", (*v)[1]());
    // printf("%d %d\n", v, fn_arr);

    // int const * r = &a;
    // r = &b;

    // int a = 10, b = 1;
    // int *const r = &a;
    // r = &b; // complete error
    // *r = 1; //可行

    // int a = 10, b = 1;
    // const int* const r = &a;
    // r = &b; // complete error
    // *r = 1; // complete error

    int arr[3] = {1, 2 ,3};

    int (*p_arr)[3] = &arr;
    // int * p = arr;
    // int (*p_arr_)[3] = arr;

    printf("%d %d\n", arr, p_arr);


}