package edu.icet.service;

import edu.icet.dto.Book;

import java.util.List;

public interface BookService {
    List<Book> getAll();
    void addBook(Book book);
    void deleteBookById(Integer id);
    Book searchBookById(Integer id);
    void updateBookById(Book book);

    List<Book> findByTitle(String title);
    List<Book> findByAuthor(String author);

    List<Book> findByCategory(String category);
}
