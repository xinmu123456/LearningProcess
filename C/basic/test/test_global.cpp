#include <iostream>
#include <string>
#include "a.h"

class Person {
public: 
    int age;
    std::string name;

    Person(int age, std::string name) : age(age), name(name) {
        printf("Person start to construct\n");
    }

    ~Person() {
        printf("Person start to destroy\n");
    }
};

Person p(1, "hello");

void show() {
    printf("%d\n", a);
}

int main(void) {
    // a = 10;
    show();
    printf("main over\n");
}