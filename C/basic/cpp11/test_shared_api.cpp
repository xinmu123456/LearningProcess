#include <memory>
#include <iostream>

struct A
{
    int data;
    A() {
        printf("default\n");
    }
    A(int i) {
        printf("A construct\n");
    }
};


int main(void) {
    std::shared_ptr<A> pA = std::make_shared<A>(); 
    std::shared_ptr<int> p1 = std::make_shared<int>(100);

    std::cout << *(p1.get()) << std::endl;  // 输出100
    p1.reset();                             // p1 置空了, 现在p1是个空指针
    std::cout << p1.get() << std::endl;     // 输出0

    std::cout << p1.use_count() << std::endl; // 输出0
    std::shared_ptr<int> p2 = p1;
    std::cout << p1.use_count() << std::endl; // 输出0

    p1.reset(new int(99));

    std::shared_ptr<std::string> ps1(new std::string("l love u"));
    // 若ps1指向一个对象, 则条件成立
    if (ps1) { // 条件成立
        std::cout << "ps1" << std::endl; // 执行
    }

    std::shared_ptr<int> p3 = std::make_shared<int>(100);
	auto p4 = std::make_shared<int>(99);
	std::cout << "p1指向的值为: " << *p3 << " p2指向的值为: " << *p4 << std::endl;
	p3.swap(p4);
	std::cout << "p1指向的值为: " << *p3 << " p2指向的值为: " << *p4 << std::endl;
}