import java.util.*;

public class books
{
    public static void main(String[] args)
    {
        Book b1 = new Book("George Orwell", "Animal Farm", 1984, 13949658);
        Book b2 = new Book("Harper Lee", "To Kill A Mockingbird", 1960, 28485838);
        Book b3 = new Book("F. Scott Fitzgerald", "The Great Gatsby", 1925, 33759327);

        Library library = new Library(b1, b2, b3);

        Scanner scanner = new Scanner(System.in);
        int choice;

        do
        {
            System.out.println("\nLibrary Menu:");
            System.out.println("\n\n1. Display all books");
            System.out.println("2. Add a book");
            System.out.println("3. Delete a book by ISBN number");
            System.out.println("4. Exit");
            System.out.print("\nEnter your choice: ");

            choice = scanner.nextInt();

            scanner.nextLine();

            switch (choice)
            {
                case 1:
                    library.displayLibraryBooks();
                    break;

                case 2:
                    System.out.print("\nEnter Author: ");
                    String author = scanner.nextLine();

                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter year: ");
                    int madeIn = scanner.nextInt();

                    System.out.print("Enter ISBN number: ");
                    int ISBN = scanner.nextInt();
                    scanner.nextLine();

                    Book newBook = new Book(author, title, madeIn, ISBN);
                    library.addBook(newBook);
                    System.out.println("\nBook added.");
                    break;

                case 3:
                    System.out.print("Enter ISBN number to delete: ");
                    int isbnToDelete = scanner.nextInt();

                    scanner.nextLine();

                    if (library.deleteBook(isbnToDelete))
                    {
                        System.out.println("Book deleted.");
                    }

                    else
                    {
                        System.out.println("Book not found.");
                    }

                    break;

                case 4:
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        while (choice != 4);
        scanner.close();
    }
}

class Library
{
    private ArrayList<Book> books;

    public Library(Book... initialBooks)
    {
        books = new ArrayList<>();
        for (Book b : initialBooks)
        {
            books.add(b);
        }
    }

    public void addBook(Book book)
    {
        books.add(book);
    }

    public boolean deleteBook(int ISBN)
    {
        return books.removeIf(b -> b.getISBN() == ISBN);
    }

    public void displayLibraryBooks()
    {
        if (books.isEmpty())
        {
            System.out.println("Library is empty.");
        }

        else
        {
            for (Book b : books)
            {
                b.displayBookInfo();
            }
        }
    }
}

class Book
{
    private String author;
    private String title;
    private int madeIn;
    private int ISBN;

    public Book(String author, String title, int madeIn, int ISBN)
    {
        this.author = author;
        this.title = title;
        this.madeIn = madeIn;
        this.ISBN = ISBN;
    }

    public String getAuthor()
    {
        return author;
    }

    public String getTitle()
    {
        return title;
    }

    public int getMadeIn()
    {
        return madeIn;
    }

    public int getISBN()
    {
        return ISBN;
    }

    public void displayBookInfo()
    {
        System.out.println
        ("Author is: " + author +
        ", title is: " + title +
        ", made in the year: " + madeIn +
        ", ISBN is: " + ISBN);
    }
}
