#include <stdio.h>
#include <string.h>

int changeOrder();

int main() 
{
    changeOrder();
    return 0;
}

int changeOrder()
{
    int c;

    FILE *file = fopen("text3.c", "r");
    if (file == NULL) 
    {
        perror("Error opening file");
        return 1;
    }

    while ((c = fgetc(file)) != EOF) 
    {
        putchar(c);

        if (c == ' ')
        {
            putchar('\n');
        }
    }

    fclose(file);
    return 0;
}