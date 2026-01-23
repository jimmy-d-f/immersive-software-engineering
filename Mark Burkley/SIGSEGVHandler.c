#include <stdio.h>
#include <signal.h>
#include <stdlib.h>

void segv_handler(int sig) {
    printf("Segmentation fault detected (signal %d). Exiting.\n", sig);  
    exit(1);
}

int main(void) {
    signal(SIGSEGV, segv_handler);  

    printf("Causing a segmentation fault now...\n");

    int *p = NULL;
    *p = 42;  

    return 0;
}
