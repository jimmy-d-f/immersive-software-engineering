#include <stdio.h>
#include <string.h>

int main() 
{
    FILE *file = fopen("text.c", "r");
    if (file == NULL) 
    {
        printf("Could not open text.c\n");
        return 1;
    }

    char line[256];

    while (fgets(line, sizeof(line), file)) 
    {
        char *comment = strstr(line, "//");
        size_t len = strlen(line);
        if (comment != NULL) 
        {
            *comment = '\0'; 
        }

        if (strlen(line) > 0) 
        {
            printf("%s\n", line);
        }
    }

    fclose(file); 
    return 0;
}