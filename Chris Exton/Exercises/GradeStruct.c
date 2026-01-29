#include <stdio.h> 

struct Student
{
    char name[50];
    int roll; 
    float marks; 
};

int main()
{
    int length = 5;
    struct Student student[5];

    for (int i = 0; i < length; i++)
    {
        printf("\nTell me the student's %d name: ", i + 1);
        scanf("%49s", student[i].name);

        printf("\nEnter roll number for student %d: ", i + 1);
        scanf("%d", &student[i].roll);

        printf("\nEnter marks for student %d: ", i + 1);
        scanf("%f", &student[i].marks);
    }

    for (int i = 0; i < length; i++)
    {
        printf("\033[32m\n\nStudent %d, their name is %s, their roll number is %d, and their marks are %.2f.\033[0m",
            i + 1, student[i].name, student[i].roll, student[i].marks);
    }

    printf("\n\n\033[31mThank you for playing!\033[0m\n");


    return 0;
}