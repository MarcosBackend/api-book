package com.books.repository;

import com.books.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookRepository extends JpaRepository<BookEntity, Long> {

    List<BookEntity> findByAuthor(String author);
    List<BookEntity> findByGender(String gender);
    List<BookEntity> findByAuthorAndGender(String author, String gender);
}
