#include <iostream>
#include <memory>

class A {
public:
    int a;
    A(int a) : a(a) {
        printf("a constructor call");
    }
};

// void func_1(std::shared_ptr<int> p) {
//     std::cout << p.use_count() << std::endl;
// }

void func_1(std::shared_ptr<int> p) {
    std::cout << p.use_count() << std::endl;
}


class B {
public:
    int data;
    B(int data) : data(data) {
        printf("拷贝构造函数的调用\n");
    }
    
    B& operator= (const B& b) {
        printf("赋值运算符调用\n");
        return *this;
    }
};

int main(void) {
    std::shared_ptr<int> p1(new int(90));
    std::shared_ptr<int> p2 = std::make_shared<int>(99);
    // 从第二种方式推测, make_shared的结果是一个右值
    // why? 因为如果是左值的话, 这里的引用计数应该为2才对, 而实际上却是1
    printf("%d\n", p2.use_count()); // 输出 1

    // 猜测证明 用右值绑定 绑定成功
    std::shared_ptr<int>&& p3 = std::make_shared<int>(100);
    printf("%d\n", p3.use_count());

    std::shared_ptr<int> p4 = std::make_shared<int>(100);
    printf("%d\n", p4.use_count());

    std::shared_ptr<int> p5(p4);
    printf("%d %d\n", p4.use_count(), p5.use_count());

    std::shared_ptr<int> p6 = std::make_shared<int>(100);
	func_1(p6);
    std::cout << p6.use_count() << std::endl;

}
