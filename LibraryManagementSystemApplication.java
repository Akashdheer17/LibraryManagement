import java.util.Scanner;

class Book {
    String title;
    String author;
    int id;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Author: " + author;
    }
}

class Library {
    static final int MAX_BOOKS = 100;
    Book[] books;
    int numBooks;

    public Library() {
        books = new Book[MAX_BOOKS];
        numBooks = 0;
    }

    public void addBook(int id, String title, String author) {
        if (numBooks < MAX_BOOKS) {
            books[numBooks] = new Book(id, title, author);
            numBooks++;
            System.out.println("Book added successfully.");
        } else {
            System.out.println("Cannot add more books. Library is full.");
        }
    }

    public void displayBooks() {
        if (numBooks == 0) {
            System.out.println("No books in the library.");
            return;
        }

        System.out.println("List of Books:");
        for (int i = 0; i < numBooks; i++) {
            System.out.println(books[i]);
        }
    }

    public void searchBook(String query) {
        boolean found = false;
        for (int i = 0; i < numBooks; i++) {
            if (books[i].title.equalsIgnoreCase(query) || books[i].author.equalsIgnoreCase(query)) {
                System.out.println("Book found: " + books[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Book not found.");
        }
    }
}

public class LibraryManagementSystemApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Search Book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    library.addBook(id, title, author);
                    break;
                case 2:
                    library.displayBooks();
                    break;
                case 3:
                    System.out.print("Enter book title or author to search: ");
                    String query = scanner.nextLine();
                    library.searchBook(query);
                    break;
                case 4:
                    System.out.println("Exiting... Thank you!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
