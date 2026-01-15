#include <stdio.h>
#define MAXLINE 1000;

void changeOrder();

int main() 
{
    printf("Give me a line of text:\n");
    char c[MAXLINE];
    
    scanf("%s", c);
    changeOrder(c);
    return 0;
}

void changeOrder(char c[])
{
    printf("You entered: %s\n", c);
}