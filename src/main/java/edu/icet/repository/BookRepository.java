package edu.icet.repository;

import edu.icet.dto.Book;
import edu.icet.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity , Integer> {
    List<BookEntity> findByTitle(String title);
    List<BookEntity> findByAuthor(String author);
    List<BookEntity> findByCategory(String category);
//
//    List<Book> findByStockLessTan(int stock);

}
