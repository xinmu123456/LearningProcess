#include "bits/stdc++.h"
#include <iostream>
using namespace std;

int main()
{

    vector<int> vec;
    int i;

    printf("vector size = %d\n", vec.size());

    for (int i = 0; i < 5; i++)
    {
        vec.push_back(i);
    }

    vector<int>::iterator v = vec.begin();
    while (v != vec.end())
    {
        printf("value of %d\n", *v);
        v++;
    }

    return 0;
}