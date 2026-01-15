#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int sumArray(int *ptr, int size) {
    int sum = 0;
    for (int i = 0; i < size; i++) {
        sum += *(ptr + i);  
    }
    return sum;
}

int main() {
    int arr[6];
    int *p = arr;   

    srand(time(NULL));

    for (int i = 0; i < 6; i++) {
        arr[i] = rand() % 100;  
    }

    printf("Address of array (arr): %p\n", arr);
    printf("Address of first element (&arr[0]): %p\n", &arr[0]);
    printf("*p (value), which is also the first value: %d\n", *p);

    printf("Array elements using indexing:\n");
    for (int i = 0; i < 6; i++) {
        printf("arr[%d] = %d\n", i, arr[i]);
    }

    printf("\nArray elements using pointer arithmetic:\n");
    for (int i = 0; i < 6; i++) {
        printf("*(p + %d) = %d\n", i, *(p + i));
    }

    for (int i = 0; i < 6; i++) {
        *(p + i) += 10;
    }

    printf("\nModified array after adding 10 to each element:\n");
    for (int i = 0; i < 6; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");

    int sum = sumArray(p, 6);
    printf("\nSum of array elements: %d\n", sum);

    return 0;
}
