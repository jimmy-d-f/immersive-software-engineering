// In C, a pointer stores the memory address of a variable and can be used to access or modify that variable indirectly
#include <stdio.h>

int main(void) {
    int value = 42;      // normal integer variable
    int *ptr = &value;   // pointer to int, stores the address of value

    printf("Value        : %d\n", value);
    printf("Address of value (&value): %p\n", (void*)&value);
    printf("Pointer ptr  : %p\n", (void*)ptr);
    printf("Value via *ptr: %d\n", *ptr);  // dereference

    // Modify value through the pointer
    *ptr = 100;

    printf("\nAfter modifying through pointer:\n");
    printf("Value        : %d\n", value);
    printf("Value via *ptr: %d\n", *ptr);

    return 0;
}