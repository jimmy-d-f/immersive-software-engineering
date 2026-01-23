#include <stdio.h>
#include <signal.h>

int main(void) {
    signal(SIGINT, SIG_IGN);   
    signal(SIGTERM, SIG_IGN);  

    printf("PID: %d\n", getpid());
    printf("Signals SIGINT and SIGTERM are being ignored.\n");

    while (1) {
        pause();  
    }

    return 0;
}
