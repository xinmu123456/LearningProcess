#include <memory>
#include <list>
#include <unordered_map>

typedef std::unordered_map<std::string, std::string> UPtrMapSS;

using UPtrMapSS_ = std::unique_ptr<std::unordered_map<std::string, std::string>>;

typedef void (*FP)(int, const std::string&);
using FP_ = void (*)(int, const std::string&);

template<typename T>
using MyAllocList = std::list<T>;

template<typename T>
struct MyAllocList_
{
    typedef std::list<T> type;
};

template<typename T>
class Widget {
private:
    typename MyAllocList<T>::type list;
};

int main(int argc, char const *argv[])
{
    MyAllocList_<int>::type lw;
    return 0;
}
