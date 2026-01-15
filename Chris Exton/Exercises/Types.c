#include <stdio.h>

int main(void) {
    char ch = 'A';          // character literal
    int code = ch;          // implicit conversion to int

    printf("Character: %c\n", ch);
    printf("As a number: %d\n", code);

    // Use char directly in arithmetic
    char next = ch + 1;     // 'B'
    int diff = 'd' - 'a';   // 3

    printf("Next character after %c is %c\n", ch, next);
    printf("'d' - 'a' = %d\n", diff);

    return 0;
}