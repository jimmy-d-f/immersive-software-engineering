#ifndef SORT_H
#define SORT_H

typedef int (*CompareFunc)(int a, int b);

void bubbleSort(int arr[], int size, CompareFunc cmp);

#endif
