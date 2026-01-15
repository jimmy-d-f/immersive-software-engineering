// In C, the value 0 is treated as false and any non-zero value is treated as true, so an int can be used as a boolean flag

#include <stdio.h>

int main(void) {
    int isEven;
    int number;

    printf("Enter an integer: ");
    scanf("%d", &number);

    /* Use int as a boolean */
    isEven = (number % 2 == 0);  /* 1 if even, 0 if odd */

    if (isEven) {
        printf("%d is even.\n", number);
    } else {
        printf("%d is odd.\n", number);
    }

    return 0;
}