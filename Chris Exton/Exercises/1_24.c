#include <stdio.h>

int main() 
{
    FILE *file = fopen("text2.c", "r");
    if (file == NULL) 
    {
        printf("Could not open text2.c\n");
        return 1;
    }

    char c;
    int braces = 0;      
    int brackets = 0;    
    int parentheses = 0; 
    int doubleQuotes = 0; 
    int singleQuotes = 0; 

    while ((c = fgetc(file)) != EOF) 
    {
        switch(c) 
        {
            case '{': braces++; break;
            case '}': braces--; break;
            case '[': brackets++; break;
            case ']': brackets--; break;
            case '(': parentheses++; break;
            case ')': parentheses--; break;
            case '"': doubleQuotes = !doubleQuotes; break;
            case '\'': singleQuotes = !singleQuotes; break;
        }
    }

    fclose(file);

    printf("Syntax check results:\n");
    printf("Braces {}: %s\n", braces == 0 ? "Balanced" : "Unbalanced");
    printf("Brackets []: %s\n", brackets == 0 ? "Balanced" : "Unbalanced");
    printf("Parentheses (): %s\n", parentheses == 0 ? "Balanced" : "Unbalanced");
    printf("Double quotes \": %s\n", doubleQuotes == 0 ? "Balanced" : "Unbalanced");
    printf("Single quotes ': %s\n", singleQuotes == 0 ? "Balanced" : "Unbalanced");

    return 0;
}
