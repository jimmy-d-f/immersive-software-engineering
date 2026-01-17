#include <stdio.h>
#include "1_4.h"

#define MAX 100
#define SAVE 1

int main(void)
{
    char choice, again;

    error:
        do 
        {
            printf("Do you want to convert from Fahrenheit to Celsius (F) or Celsius to Fahrenheit (C)? ");
            scanf(" %c", &choice);

            if (choice == 'F' || choice == 'f') 
            {
                calcCelsius();
            }
            else if (choice == 'C' || choice == 'c') 
            {
                calcFahrenheit();
            }
            else 
            {
                printf("Invalid choice. Please enter 'F' or 'C'.\n");
                goto error;
            }

            printTemperature();

            printf("Would you like to perform another conversion? (Y/N): ");
            scanf(" %c", &again);

        } 
        while (again == 'Y' || again == 'y');

    printf("Thank you for using the temperature converter. Goodbye!\n");
    return 0;
}

void calcFahrenheit(void)
{
    if (historyCount >= MAX)
    {
        printf("History is full.\n");
        return;
    }

    printf("Enter temperature in Celsius: ");
    scanf("%f", &celsiusHistory[historyCount]);

    fahrenheitHistory[historyCount] = 
        (celsiusHistory[historyCount] * 9.0 / 5.0) + 32;

    historyCount++;
}

void calcCelsius(void)
{
    if (historyCount >= MAX) 
    {
        printf("History is full.\n");
        return;
    }

    printf("Enter temperature in Fahrenheit: ");
    scanf("%f", &fahrenheitHistory[historyCount]);

    celsiusHistory[historyCount] =
        (fahrenheitHistory[historyCount] - 32) * 5.0 / 9.0;

    historyCount++;
}


#if SAVE
    void printTemperature(void)
    {
        printf("\n--- Conversion History ---\n");

        for (int i = 0; i < historyCount; i++) 
        {
            printf("%d) %.2f Celsius = %.2f Fahrenheit\n",
                i + 1,
                celsiusHistory[i],
                fahrenheitHistory[i]);
        }

        printf("\n");
    }
#endif