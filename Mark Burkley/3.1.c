#include <string.h>

int main(int argc, char *argv[]) {
    if (argc < 2)
        return 2;            

    if (strcmp(argv[1], "secret") == 0)
        return 0;            

    return 1;               
}
