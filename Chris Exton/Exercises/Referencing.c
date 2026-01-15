#include <stdio.h>
int main(void) {
    int x = 42;        // a normal int
    int *p = &x;       // p stores the address of x
    printf("x      = %d\n", x);
    printf("&x     = %p\n", (void*)&x);  // address of x
    printf("p      = %p\n", (void*)p);   // same address as &x
    printf("*p     = %d\n", *p);         // value at that address (42)
    printf("*(&x)  = %d\n", *(&x));      // dereference(address of x) -> x
    *p = 100;         // write through the pointer
    printf("x after *p = 100: %d\n", x);
    return 0;
}