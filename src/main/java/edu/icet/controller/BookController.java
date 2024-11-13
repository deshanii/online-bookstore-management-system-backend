package edu.icet.controller;

import edu.icet.dto.Book;
import edu.icet.repository.BookRepository;
import edu.icet.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
@CrossOrigin
//http://localhost:4200/

public class BookController {
    private final BookService service;
    private final BookRepository repository;

    @GetMapping("/get-book")
        public List<Book> getBook(){
            return service.getAll();
    }

    @PostMapping("/add-book")
    @ResponseStatus(HttpStatus.CREATED)
    public void addBook(@RequestBody Book book){
        System.out.println(book);
        service.addBook(book);
    }

    @GetMapping("/search-by-id/{id}")
    public Book getBookById(@PathVariable Integer id){
        System.out.println(id);
        return service.searchBookById(id);
    }

    @DeleteMapping("/delete-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteBookById(@PathVariable Integer id){
        service.deleteBookById(id);
    }

    @PutMapping("/update-book")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateBook(@RequestBody Book book){
        service.updateBookById(book);
    }

    @GetMapping("/search-by-title")
    public List<Book> searchByTitle(@RequestParam String title){
        return service.findByTitle(title);
    }


    @GetMapping("/filter-by-category")
    public List<Book> filterByCategory(@RequestParam String category){
        return service.findByCategory(category);
    }

    @GetMapping("/filter-by-author")
    public List<Book> filterByAuthor(@RequestParam String author){
        return service.findByAuthor(author);
    }

}
