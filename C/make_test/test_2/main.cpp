#include <iostream>
#include "add.cpp"

extern int add(int a, int b);

int main(void)
{
	add(1, 2);
	printf("hello world\n");
}

