#include <stdio.h>

int main() 
{
    int a = 1;
    int b = 2;
    printf("a: %d, b: %d\n", a, b);

    compute_ops(&a, &b);
    printf("a: %d, b: %d\n", a, b);
    return 0;
}

void compute_ops(int* a, int* b)
{
    *a = 2;
    *b = 3;
}