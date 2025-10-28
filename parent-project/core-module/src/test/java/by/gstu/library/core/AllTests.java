package by.gstu.library.core;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AllTests {

    private static Library library;
    private static Author tolstoy, austen;

    @BeforeAll
    static void setUp() {
        library = new Library();
        tolstoy = new Author("Leo Tolstoy");
        austen = new Author("Jane Austen");

        library.addBook(new Book("War and Peace", 1869, tolstoy));
        library.addBook(new Book("Anna Karenina", 1878, tolstoy));
        library.addBook(new Book("Pride and Prejudice", 1813, austen));
    }

    @Test
    void testSearchByAuthor_Tolstoy() {
        List<Book> books = library.searchByAuthor("Leo Tolstoy");
        assertEquals(2, books.size());
        assertTrue(books.stream().anyMatch(b -> b.getTitle().equals("War and Peace")));
    }

    @Test
    void testSearchByAuthor_Austen() {
        List<Book> books = library.searchByAuthor("Jane Austen");
        assertEquals(1, books.size());
    }

    @Test
    void testSearchByAuthor_Unknown() {
        assertTrue(library.searchByAuthor("Unknown").isEmpty());
    }

    @Test
    void testFilterByYear_1813() {
        List<Book> books = library.filterByYear(1813);
        assertEquals(1, books.size());
        assertEquals("Pride and Prejudice", books.get(0).getTitle());
    }

    @Test
    void testFilterByYear_NoBooks() {
        assertTrue(library.filterByYear(2000).isEmpty());
    }

    @Test
    void testAuthorName() {
        assertEquals("Leo Tolstoy", tolstoy.getName());
    }

    @Test
    void testBookTitleAndYear() {
        Book book = new Book("1984", 1949, new Author("George Orwell"));
        assertEquals("1984", book.getTitle());
        assertEquals(1949, book.getYear());
    }

    @Test
    void testReaderName() {
        Reader reader = new Reader("Ivan Ivanov");
        assertEquals("Ivan Ivanov", reader.getName());
    }
}