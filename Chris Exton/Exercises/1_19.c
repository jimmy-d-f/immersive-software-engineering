#include <stdio.h>
#include <string.h> 
#define MAXLINE 1000

void changeOrder();

int main() 
{
    char c[MAXLINE];

    printf("Give me a line of text:\n");
    
    if (fgets(c, MAXLINE, stdin) == NULL) 
    {
        return 1;
    }
    changeOrder(c);
    return 0;
}

void changeOrder(char c[])
{
    int i = 0;
    int j = strlen(c) - 1;

    if (j >= 0 && c[j] == '\n') 
    {
        j--;
    }

    while (i < j) 
    {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
        i++;
        j--;
    }

    printf("You entered: %s\n", c);
}