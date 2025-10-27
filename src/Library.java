package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    // Поиск по автору
    public List<Book> searchByAuthor(String authorName) {
        return books.stream()
                .filter(book -> book.getAuthor().getName().equalsIgnoreCase(authorName))
                .collect(Collectors.toList());
    }

    // Фильтрация по году
    public List<Book> filterByYear(int year) {
        return books.stream()
                .filter(book -> book.getYear() == year)
                .collect(Collectors.toList());
    }
}