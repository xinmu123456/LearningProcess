#include <iostream>
#include <cstdio>

using namespace std;

int main()
{
    int n;
    int num;
    char name;
    int nc = 0, nr = 0, nf = 0, sum = 0;
    double gc, gr, gf;
    printf("%d %d %d %d", nc, nr, nf, sum);
    cin >> n;
    
    for(int i = 0; i < n; i++)
    {
        cin >> num >> name;
        if(name == 'C')
            nc += num;
        else if(name == 'R')
            nr += num;
        else if(name == 'F')
            nf += num;
        sum += num;
    }
    gc = (double)nc / (double)sum * 100;
    gr = (double)nr / (double)sum * 100;
    gf = (double)nf / (double)sum * 100;
    
    printf("Total: %d animals\n", sum);
    printf("Total coneys: %d\n", nc);
    printf("Total rats: %d\n", nr);
    printf("Total frogs: %d\n", nf);
    printf("Percentage of coneys: %.2lf %\n", gc);
    printf("Percentage of rats: %.2lf %\n", gr);
    printf("Percentage of frogs: %.2lf %\n", gf);

    return 0;
}