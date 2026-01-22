#include <stdio.h>

// 1. Two different print functions
void print_upper(const char* s) { 
    printf("%s (UPPER): ", s);
    for (; *s; s++) printf("%c", (*s >= 'a' && *s <= 'z') ? *s-32 : *s);
    printf("\n");
}

void print_lower(const char* s) { 
    printf("%s (lower): ", s);
    for (; *s; s++) printf("%c", (*s >= 'A' && *s <= 'Z') ? *s+32 : *s);
    printf("\n");
}

int main(void) {
    const char* text = "Hello World";
    
    // 2. Function pointer for void func(const char*)
    void (*formatter)(const char*);
    
    printf("Original: %s\n\n", text);
    
    // 3. Point to UPPER formatter
    formatter = print_upper;
    formatter(text);    // calls print_upper
    
    // 4. Point to lower formatter  
    formatter = print_lower;
    formatter(text);    // calls print_lower
    
    // 5. Show function addresses
    printf("\nformatter -> %p\n", (void*)formatter);
    printf("&print_lower: %p\n", (void*)&print_lower);
    
    return 0;
}