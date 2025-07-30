package com.books.presentation.controller;

import com.books.presentation.dto.BookDTO;
import com.books.service.implementation.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/book/")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("create")
    public ResponseEntity<BookDTO> createBook(@RequestBody @Valid BookDTO bookDTO) {
        return new ResponseEntity<>(this.bookService.createBook(bookDTO), HttpStatus.CREATED);
    }

    @GetMapping("find")
    public ResponseEntity<List<BookDTO>> findAll() {
        return new ResponseEntity<>(this.bookService.findAll(), HttpStatus.OK);
    }

    @GetMapping("find/author")
    public ResponseEntity<List<BookDTO>> findByAuthor(@RequestParam String author) {
        return new ResponseEntity<>(this.bookService.findByAuthor(author), HttpStatus.OK);
    }

    @GetMapping("find/gender")
    public ResponseEntity<List<BookDTO>> findByGender(@RequestParam String gender) {
        return new ResponseEntity<>(this.bookService.findByGender(gender), HttpStatus.OK);
    }

    @GetMapping("find/author/gender")
    public ResponseEntity<List<BookDTO>> findByAuthorAndGender(@RequestParam String author, @RequestParam String gender) {
        return new ResponseEntity<>(this.bookService.findByAuthorAndGender(author, gender), HttpStatus.OK);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<BookDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(this.bookService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Integer> deleteBook(@PathVariable Long id) {
        this.bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Long id, @RequestBody @Valid BookDTO bookDTO) {
        return new ResponseEntity<>(this.bookService.updateBook(id, bookDTO), HttpStatus.OK);
    }
}
