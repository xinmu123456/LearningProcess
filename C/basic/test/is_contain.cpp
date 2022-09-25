#include <map>
#include <set>
#include <iostream>
#include <algorithm>
#include <vector>

int main(void) {
    std::vector<int> v {1, 2, 3, 4 ,5};

    std::for_each(v.rbegin(), v.rend(), [](int x) {printf("%d ",x);});

    std::vector<int>::iterator it = std::find(v.begin(), v.end(), 6);
    
    std::cout << *v.rend() << std::endl;
    std::cout << *v.rbegin() << std::endl;
    std::cout << *v.end() << std::endl;
    std::cout << *v.begin() << std::endl;

    std::map<int, int> m {{4, 5}, {5, 34}};
    m[0] = 1;
    m[1] = 2;
    m[2] = 3;

    std::for_each(m.begin(), m.end(), [](std::pair<int, int> p) {printf("%d => %d\n", p.first, p.second);});

    std::set<int> s;
    s.insert(2);
    s.insert(21);
    s.insert(23);

    std::for_each(s.begin(), s.end(), [](int x) {
        printf("%d\n", x);
    });

    std::set<int>::iterator its = s.begin();
    do {
        printf("%d \n", *its);
        ++its;
    } while (its != s.end());


}