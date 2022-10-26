#include <iostream>

int main(void) {
    
    // int n;
    // while (std::cin >> n) // ctrl + z | ctrl + c
    // {
    //     std::cout << n << " | " << std::endl;
    // }

    int data;

    std::cin >> std::oct;

    std::cin >> data;
    std::cout << data;


    std::cin >> std::dec;

    std::cin >> data;
    std::cout << data;


}