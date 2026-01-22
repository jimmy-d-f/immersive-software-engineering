#include <stdio.h>
// Function PROTOTYPE (declaration)
int addNumbers(int a, int b);
int main() {
    int result = addNumbers(5, 3);
    printf("5 + 3 = %d\n", result);
    return 0;
}
// Function DEFINITION (implementation)
int addNumbers(int a, int b) {
    return a + b;
}