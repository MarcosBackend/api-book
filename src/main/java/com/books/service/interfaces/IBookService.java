package com.books.service.interfaces;

import com.books.presentation.dto.BookDTO;

import java.util.List;

public interface IBookService {

    BookDTO createBook(BookDTO bookDTO);
    List<BookDTO> findAll();
    List<BookDTO> findByAuthor(String author);
    List<BookDTO> findByGender(String gender);
    List<BookDTO> findByAuthorAndGender(String author, String gender);
    BookDTO findById(Long id);
    void deleteBook(Long id);
    BookDTO updateBook(Long id, BookDTO bookDTO);
}
