#include <stdio.h>
#include "1_3.h"

int main(void) 
{
    error:
        printf("Do you want to convert from Fahrenheit to Celsius (C) or Celsius to Fahrenheit (F)? ");
        char choice;
        scanf(" %c", &choice);
        if (choice == 'F' || choice == 'f') 
        {
            calcFahrenheit();
        } 
        else if (choice == 'C' || choice == 'c') 
        {
            calcCelsius();
        } 
        else 
        {
            printf("Invalid choice. Please enter 'F' or 'C'.\n");
            goto error;
        }
    return 0;
}

float celsius, fahrenheit;

void calcFahrenheit()
{
    printf("Enter temperature in Celsius: ");
    scanf("%f", &celsius);
    fahrenheit = (celsius * 9/5) + 32;
    printf("%.2f Celsius is %.2f Fahrenheit.\n", celsius, fahrenheit);
}

void calcCelsius()
{
    printf("Enter temperature in Fahrenheit: ");
    scanf("%f", &fahrenheit);
    celsius = (fahrenheit - 32) * 5/9;
    printf("%.2f Fahrenheit is %.2f Celsius.\n", fahrenheit, celsius);
}