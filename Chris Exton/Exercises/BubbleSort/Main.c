#include "Sort.h"
#include "Compare.h"
#include <stdio.h>

int main() {
    int arr[] = {64, 34, 25, 12, 22, 11, 90};
    int size = 7;

    printf("Original: ");
    for (int i = 0; i < size; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");

    int asc[7];
    for (int i = 0; i < size; i++) {
        asc[i] = arr[i];
    }
    bubbleSort(asc, size, ascending);

    printf("Ascending: ");
    for (int i = 0; i < size; i++) {
        printf("%d ", asc[i]);
    }
    printf("\n");

    int desc[7];
    for (int i = 0; i < size; i++) {
        desc[i] = arr[i];
    }
    bubbleSort(desc, size, descending);

    printf("Descending: ");
    for (int i = 0; i < size; i++) {
        printf("%d ", desc[i]);
    }
    printf("\n");

    return 0;
}
