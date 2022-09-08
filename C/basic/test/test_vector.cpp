#include <iostream>
#include <vector>
using std::vector, std::cout, std::endl;


int main(int argc, char const *argv[])
{
    vector<int> v;

    cout << &v << endl;

    v.emplace_back(1);
    v.emplace_back(1);
    v.emplace_back(1);

    int i = 1;
    cout << &i << endl;

    cout << &v.at(0) << endl;
    cout << &v.at(1) << endl;
    cout << &v.at(2) << endl;

    return 0;
}
