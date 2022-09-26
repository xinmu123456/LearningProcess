#include <iostream>
#include <memory>
using std::shared_ptr, std::weak_ptr, std::cout, std::endl;

class B;

class A {
public:
    shared_ptr<B> p;

    ~A () {
        cout << "A析构成功\n" << endl;
    }
};

class B {
public:
    shared_ptr<A> p;
    // weak_ptr<A> p;
    
    ~B () {
        cout << "B析构成功\n" << endl;
    }
};


int main(void) {

    shared_ptr<A> father = std::make_shared<A>();
    shared_ptr<B> son = std::make_shared<B>();

    father -> p = son;
    son -> p = father;

    // father -> p.reset(); // 手动释放

    cout << "main 中引用计数 \n父: " << father.use_count() << "\n子: " << son.use_count() << endl;

}