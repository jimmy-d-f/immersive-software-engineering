#include <stdio.h>
#define MAXLINE 1000

int main(void)
{
	char input [MAXLINE];

	scanf("%999s", input);
	printf("Sarah wanted me to write this: %s\n", input);
	return 0;
}
