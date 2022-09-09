template <typename T>
class St
{
public:
    typedef int INT;
    T data;
};

typedef struct Temp{
    int data;
    char ch;
} Temp;


int main(int argc, char const *argv[])
{
    St<int>::INT i;
    St<int> s = {1};

    Temp t = {1 , 'c'};

    return 0;
}
