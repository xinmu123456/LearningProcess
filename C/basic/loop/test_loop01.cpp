#include <stdio.h>
#include <vector>

int main(int argc, char const *argv[])
{
    for (int i = 0; i < 10; i++)
        printf("%d", i);

    for (int i = 0; i < 10; i++)
    {
        printf("%d", i);
    }

    int *p = nullptr;

    std::vector<int> v;
    v.push_back(1);
    v.push_back(2);
    v.push_back(3);

    for (auto &&vec : v)
    {
        printf("%d\n", vec);
    }

    return 0;
}
