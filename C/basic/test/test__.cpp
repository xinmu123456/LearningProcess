#include <cstdio>

int main(void)
{
    int m, k = 0, s = 0;
    for (m = 1; m <= 4; m++)
    {
        switch(m % 4)
        {
            case 0:
            case 1: s += m; break;
            case 2:
            case 3: s -= m; break;
        }
        k += s;
    }

    
    printf("%d", k);
}