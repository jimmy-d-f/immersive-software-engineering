#include <stdio.h>
int main() 
{
    int val = 42;
    int* ptr = &val;
    int** ptr_to_ptr = &ptr;

    printf("%p\n", (void*)ptr);
    printf("%p\n", (void*)ptr_to_ptr);

    printf("%d\n", *ptr);
    printf("%d\n", **ptr_to_ptr);
    printf("%p\n", (void*)*ptr_to_ptr);
    printf("%d\n", **ptr_to_ptr);
    
    
    return 0;
}