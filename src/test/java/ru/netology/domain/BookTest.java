package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    private Book book = new Book();

    @Test
    public void shouldCheckMatchesByName() {
        Book book = new Book(1, "DIAmond WisDOM", 100, "Michael ROACH");
        String searchText = "diamond WISDOM";

        assertEquals(true, book.matches(searchText));
    }

    @Test
    public void shouldCheckMatchesByAuthor() {
        Book book = new Book(1, "DIAmond WisDOM", 100, "Michael ROACH");
        String searchText = "MICHAEL ROACH";

        assertEquals(true, book.matches(searchText));
    }

    @Test
    public void shouldCheckNotMatchesByName() {
        Book book = new Book(1, "DIAmond WisDOM", 100, "Michael ROACH");
        String searchText = "diamond WISDOM diamond";

        assertEquals(false, book.matches(searchText));
    }

    @Test
    public void shouldCheckNotMatchesByAuthor() {
        Book book = new Book(1, "DIAmond WisDOM", 100, "Michael ROACH");
        String searchText = "MICHAEL ROACH 123";

        assertEquals(false, book.matches(searchText));
    }
}