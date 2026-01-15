#include <stdio.h>

int main() 
{
    int c, i;
    i = 1;
    FILE *file = fopen("text.c", "r");

    if (file == NULL) 
    {
        perror("Error opening file");
        return 1;
    }

    while ((c = fgetc(file)) != EOF)
    {
        if (c == '\n') 
        {
            i++;
        }
    }

    printf("Number of lines: %d\n", i);
    fclose(file);
    return 0;
}