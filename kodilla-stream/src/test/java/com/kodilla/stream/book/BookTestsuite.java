package com.kodilla.stream.book;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

public class BookTestsuite {
    @Test
    public void testGetListUsingFor() {
        //Given
        BookDirectory bookDirectory = new BookDirectory();

        //When
        List<Book> books = bookDirectory.getList();

        //Then
        int numberOfBooksPublicatedAfter2007 = 0;
        for (Book book : books) {
            if (book.getYearOfPublication() > 2007) {
                numberOfBooksPublicatedAfter2007++;
            }
        }
        assertEquals(3, numberOfBooksPublicatedAfter2007);
    }

    @Test
    public void testGetListUsingIntStream() {
        //Given
        BookDirectory bookDirectory = new BookDirectory();

        //When
        List<Book> books = bookDirectory.getList();

        //Then
        int numberOfBooksPublicatedAfter2007 = IntStream.range(0, books.size())
                .filter(n -> books.get(n).getYearOfPublication() > 2007)
                .map(n -> 1)
                .sum();
        assertEquals(3, numberOfBooksPublicatedAfter2007);
    }

    @Test
    public void testGetListUsingIntStreamCount() {
        //Given
        BookDirectory bookDirectory = new BookDirectory();

        //When
        List<Book> books = bookDirectory.getList();

        //Then
        long numberOfBooksPublicatedAfter2007 = IntStream.range(0, books.size())
                .filter(n -> books.get(n).getYearOfPublication() > 2007)
                .count();
        assertEquals(3, numberOfBooksPublicatedAfter2007);
    }
}