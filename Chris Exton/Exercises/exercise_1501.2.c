#include <stdio.h>

int main(void) {
    int arr [5] = {0, 1, 2, 3, 4};
    int* ptr = arr;
    printf("\nSize of array elements using pointer arithmetic:\n");
    for (int i = 0; i < 5; i++) {
        printf("Element %d: %d\n", i, *(ptr + i));
    }

    printf("\nSize of array using sizeof operator:\n");
    printf("Size of arr: %zu bytes\n", sizeof(arr));
    printf("Size of each element: %zu bytes\n", sizeof(arr[0]));
    printf("Number of elements in arr: %zu\n", sizeof(arr) / sizeof(arr[0]));

    int i;
    float f;
    double d;
    char c;

    int* pi = &i;
    float* pf = &f;
    double* pd = &d;
    char* pc = &c;

    printf("\nSize of pointers:\n");
    printf("sizeof(pi) = %zu bytes\n", sizeof(pi));
    printf("sizeof(pf) = %zu bytes\n", sizeof(pf));
    printf("sizeof(pd) = %zu bytes\n", sizeof(pd));
    printf("sizeof(pc) = %zu bytes\n", sizeof(pc));

    return 0;
}