#include <iostream>
using std::cout, std::endl;

template<typename T>
class Node{
public:
    T data;
    Node* next;
};


int main(void) {
    int i = 0;
    int&& a = i++;
    a = 10;
    cout << a << i << endl;

    typedef Node<int> NodeI;

    NodeI* ni = new NodeI();
    ni->data = 1;
    ni->next = nullptr;
    cout << "------------" << endl;
    cout << ni->data << ni->next << endl;

}