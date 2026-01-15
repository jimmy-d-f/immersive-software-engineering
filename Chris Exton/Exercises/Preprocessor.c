// The C preprocessor runs before compilation and handles things like macros and #include directives

#include <stdio.h>

// Object-like macro
#define PI 3.14159

// Function-like macro
#define SQUARE(x) ((x) * (x))

// Conditional compilation
#define DEBUG 1

int main(void) {
    int r = 5;
    int area = (int)(PI * SQUARE(r));

    printf("Radius: %d\n", r);
    printf("Area (approx): %d\n", area);

#if DEBUG
    printf("Debug: PI used = %f\n", PI);
    printf("Debug: SQUARE(%d) = %d\n", r, SQUARE(r));
#endif

    return 0;
}