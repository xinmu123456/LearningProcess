#include <iostream>

int seq[6] = {567, 142, 426, 811, 8520, 50};
const int dep = 5;
char _sym[10] = {};

int find_zero(int dep, int cur_val, char sym) {
    

    if (dep > ::dep) {
        if (cur_val == 0)
            return 1;
        return 0;
    }
    
    int layer_ret;

    // if (dep == 0)
    //     layer_ret = find_zero(dep + 1, cur_val + seq[dep], '+');
    // else 
    layer_ret = find_zero(dep + 1, cur_val + seq[dep], '+') || find_zero(dep + 1, cur_val - seq[dep], '-') || find_zero(dep + 1, cur_val * seq[dep], '*');

    // cur_val += seq[dep];

    if (layer_ret == 1 && dep > 0)
        ::_sym[dep] = sym;

    return layer_ret;
    // cur_val -= seq[dep];
    // find_zero(dep + 1, cur_val - seq[dep], sym);

    // cur_val *= seq[dep];
    // find_zero(dep + 1, cur_val * seq[dep], sym);


}

int main(int argc, char const *argv[])
{
    
    find_zero(1, seq[0], '#');

    return 0;
}
