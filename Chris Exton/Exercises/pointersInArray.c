#include <stdio.h>

int main(void) 
{
    int arr [5] = {10, 20, 30, 40, 50};
    int* ptr = arr; 
    printf("%p\n", (void*)ptr);

    for (int i = 0; i < 5; i++) 
    {
        printf("Element %d: %d\n", i, *(ptr + i));
    }
    printf("\n");

    *(arr + 1) = 22;
    printf("Modified second element: %d\n", arr[1]);
    printf("Array contents: ");
    for (int i = 0; i < 5; i++) 
    {
        printf("%d ", arr[i]);
    }
    printf("\n");
    return 0;
}