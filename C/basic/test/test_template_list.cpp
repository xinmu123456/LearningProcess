#include <list>

template <typename T>
using Tlist = std::list<T>;

template <typename T>
struct TList
{
    typedef std::list<T> type;
};


int main(int argc, char const *argv[])
{
    Tlist<int> tl;

    TList<int>::type tL;
    return 0;
}
