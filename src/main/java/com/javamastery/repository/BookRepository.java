package com.javamastery.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.javamastery.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
  List<Book> findByPublished(boolean published);
  List<Book> findByTitleContaining(String title);
  
  @Query(value = "SELECT b FROM Book b WHERE title = :title ")
  List<Book> findByTitle(@Param("title") String title);
  
}
