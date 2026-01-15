#include <stdio.h>

int main() 
{
    int c;

    printf("Type characters:\n");

    while (1) 
    {
        c = getchar();
        int is_not_eof = (c != EOF);

        printf("getchar() returned: %d, getchar() != EOF evaluates to: %d\n", c, is_not_eof);

        if (c == EOF) 
        {
            break; 
        }
    }

    return 0;
}
