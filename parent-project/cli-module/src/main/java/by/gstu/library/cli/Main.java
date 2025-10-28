package by.gstu.library.cli;

import by.gstu.library.core.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Author author1 = new Author("Leo Tolstoy");
        Author author2 = new Author("Jane Austen");
        Author author3 = new Author("George Orwell");

        library.addBook(new Book("War and Peace", 1869, author1));
        library.addBook(new Book("Anna Karenina", 1878, author1));
        library.addBook(new Book("Pride and Prejudice", 1813, author2));
        library.addBook(new Book("Sense and Sensibility", 1811, author2));
        library.addBook(new Book("1984", 1949, author3));
        library.addBook(new Book("Animal Farm", 1945, author3));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1: Поиск по автору, 2: Фильтр по году, 3: Выход");
            System.out.print("Выберите действие: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Ошибка: введите число (1, 2 или 3).");
                scanner.nextLine();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Введите имя автора: ");
                String author = scanner.nextLine();
                System.out.println("Книги автора " + author + ":");
                library.searchByAuthor(author).forEach(b -> System.out.println("- " + b.getTitle() + " (" + b.getYear() + ")"));
                if (library.searchByAuthor(author).isEmpty()) {
                    System.out.println("Книги не найдены.");
                }
            } else if (choice == 2) {
                System.out.print("Введите год: ");
                if (!scanner.hasNextInt()) {
                    System.out.println("Ошибка: введите корректный год.");
                    scanner.nextLine();
                    continue;
                }
                int year = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Книги за " + year + " год:");
                library.filterByYear(year).forEach(b -> System.out.println("- " + b.getTitle() + " (" + b.getYear() + ")"));
                if (library.filterByYear(year).isEmpty()) {
                    System.out.println("Книги не найдены.");
                }
            } else if (choice == 3) {
                System.out.println("Программа завершена.");
                break;
            } else {
                System.out.println("Ошибка: выберите 1, 2 или 3.");
            }
        }
        scanner.close();
    }
}