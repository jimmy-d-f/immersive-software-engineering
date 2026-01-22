#include <stdio.h>
#include <math.h>


    double add(double a, double b)
    {
        return a + b; 
    }

    double subtract(double a, double b)
    { 
        return a - b; 
    }

    double multiply(double a, double b)
    { 
        return a * b; 
    }

    double divide(double a, double b)
    { 
        return a / b; 
    }

int main() {

    double num1, num2;
    char operator;
    double (*operation) (double, double);

    printf("Welcome to the Function Pointer Calculator!\n");
    printf("Enter first number: ");
    scanf("%lf", &num1);
    printf("Enter an operation. Would you like to divide (/), multiply (*), add (+), or subtract (-): ");
    scanf(" %c", &operator);
    printf("Enter second number: ");
    scanf("%lf", &num2);
    printf("Calculating...\n");

    double result;

    switch (operator) {
        case '+':
            operation = add;
            break;
        case '-':
            operation = subtract;
            break;
        case '*':
            operation = multiply;
            break;
        case '/':
            if (num2 != 0) {
                operation = divide;
            } else {
                printf("You cannot divide by zero. \n");
                return 1;
            }
            break;
        default:
            printf("Invalid operator.\n");
            return 1;
    }

    printf("\nResult: %g %c %g = %g\n", num1, operator, num2, result);

    return 0;
}