#include <iostream>
#include <time.h>
#include <chrono>

int main(int argc, char const *argv[])
{
    clock_t start = clock();

    int sum = 0;
    for (int i = 0; i < 100000000; i++) sum += i;

    clock_t end = clock();

    std::cout << end - start << std::endl;

    
    std::cout << "秒: " << std::chrono::duration_cast<std::chrono::milliseconds>(std::chrono::system_clock::now().time_since_epoch()).count() << std::endl;

    char str[80];
    // strftime(str, 64, "%Y-%m-%d %H:%M:%S",  std::chrono::duration_cast<std::chrono::milliseconds>(std::chrono::system_clock::now().time_since_epoch()).count());
    
    time_t now;
    time(&now);

    char s[100];
    tm tm = *localtime(&now);

    strftime(s, sizeof(s), "%Y-%m-%d %H:%M:%S", &tm);
    printf("%d : %s\n", now, s);

    return 0;
}
