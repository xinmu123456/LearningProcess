#include <memory>

struct B; 
struct A{ 
	std::shared_ptr<B> b;
};

struct B{
	std::shared_ptr<A> a;
}; 


int main(int argc, char const *argv[])
{
    auto pa = std::make_shared<A>();
    auto pb = std::make_shared<B>(); 
    pa->b = pb;
    pb->a = pa;
}

