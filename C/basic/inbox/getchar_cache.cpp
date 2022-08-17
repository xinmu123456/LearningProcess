#include <iostream>

int main(int argc, char const *argv[])
{
    char c;

    c = getchar();

    printf("%c\n", c);

    system("pause");

    while ((c = getchar()) != '\n')
    {
        printf("%c", c);
    }
    
    return 0;
}
