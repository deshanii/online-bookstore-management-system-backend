package edu.icet.service.Impl;

import edu.icet.dto.Book;
import edu.icet.entity.BookEntity;
import edu.icet.repository.BookRepository;
import edu.icet.service.BookService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<Book> getAll() {
       List<Book> bookList = new ArrayList<>();

       List<BookEntity> bookEntities = repository.findAll();

       for(BookEntity bookEntity : bookEntities){
           bookList.add(mapper.map(bookEntity, Book.class));
       }
       return bookList;
    }

    @Override
    public void addBook(Book book) {
        repository.save(mapper.map(book,BookEntity.class));
    }

    @Override
    public void deleteBookById(Integer id) {
        repository.deleteById(id);

    }

    @Override
    public Book searchBookById(Integer id) {
        return mapper.map(repository.findById(id),Book.class);
    }

    @Override
    public void updateBookById(Book book) {
        repository.save(mapper.map(book,BookEntity.class));

    }

    @Override
    public List<Book> findByTitle(String title) {
        List<Book> bookList = new ArrayList<>();

        List<BookEntity> bookEntities = repository.findByTitle(title);

        for(BookEntity bookEntity : bookEntities){
            bookList.add(mapper.map(bookEntity, Book.class));
        }
        return bookList;

    }

    @Override
    public List<Book> findByCategory(String category) {
        List<Book> bookList = new ArrayList<>();

        List<BookEntity> bookEntities = repository.findByCategory(category);

        for(BookEntity bookEntity : bookEntities){
            bookList.add(mapper.map(bookEntity, Book.class));
        }
        return bookList;
    }

    @Override
    public List<Book> findByAuthor(String author) {
        List<Book> bookList = new ArrayList<>();

        List<BookEntity> bookEntities = repository.findByAuthor(author);

        for(BookEntity bookEntity : bookEntities){
            bookList.add(mapper.map(bookEntity, Book.class));
        }
        return bookList;
    }
}
