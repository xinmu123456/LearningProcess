#include <iostream>
#include <algorithm>

FILE* fp;

int main(int argc, char const *argv[])
{
    double d1[6], d2[6];
    fp = fopen("D:/Code/LearningProcess/a.txt", "r");

    if (fp == nullptr)
        return -1;

    int i = 0;
    while (fscanf(fp, "%lf %lf", &d1[i], &d2[i]) != EOF)
        i++;


    i = 0;
    std::for_each(d1, d1 + 6, [&d1, &d2, &i](double x) {printf("%lf %lf %lf\n", d1[i], d2[i], x); ++i;});

    fclose(fp);
    return 0;
}
