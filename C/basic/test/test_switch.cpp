#include <cstdio>
#include <string>

int main(void)
{
	int m;
	scanf("%d", &m);

    std::string str;
	switch(m % 4)
	{
		case 0:
		case 1:
			printf("YES\n");
			break;
		case 2:
			printf("NO\n");
			break;
		default:
			printf("OTHER\n");
			break;
	}
}
