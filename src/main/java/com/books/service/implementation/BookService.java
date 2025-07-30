package com.books.service.implementation;

import com.books.entities.BookEntity;
import com.books.exceptions.BookNotFound;
import com.books.presentation.dto.BookDTO;
import com.books.repository.IBookRepository;
import com.books.service.interfaces.IBookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService implements IBookService {

    @Autowired
    private IBookRepository bookRepository;

    @Override
    public BookDTO createBook(BookDTO bookDTO) {
        ModelMapper modelMapper = new ModelMapper();
        BookEntity book = modelMapper.map(bookDTO, BookEntity.class);
        this.bookRepository.save(book);
        return bookDTO;
    }

    @Override
    public List<BookDTO> findAll() {
        ModelMapper modelMapper = new ModelMapper();
        return this.bookRepository.findAll()
                .stream()
                .map(entity -> modelMapper.map(entity, BookDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDTO> findByAuthor(String author) {
        ModelMapper modelMapper = new ModelMapper();
        return this.bookRepository.findByAuthor(author)
                .stream()
                .map(entity -> modelMapper.map(entity, BookDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDTO> findByGender(String gender) {
        ModelMapper modelMapper = new ModelMapper();
        return this.bookRepository.findByGender(gender)
                .stream()
                .map(entity -> modelMapper.map(entity, BookDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDTO> findByAuthorAndGender(String author, String gender) {
        ModelMapper modelMapper = new ModelMapper();
        return this.bookRepository.findByAuthorAndGender(author, gender)
                .stream()
                .map(entity -> modelMapper.map(entity, BookDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO findById(Long id) {
        BookEntity book = this.findBook(id);
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(book, BookDTO.class);
    }

    @Override
    public void deleteBook(Long id) {
        BookEntity book = this.findBook(id);
        this.bookRepository.delete(book);
    }

    @Override
    public BookDTO updateBook(Long id, BookDTO bookDTO) {
        BookEntity book = this.findBook(id);
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setGender(bookDTO.getGender());
        book.setYearPublication(bookDTO.getYearPublication());
        this.bookRepository.save(book);
        return bookDTO;
    }

    private BookEntity findBook(Long id) {
        return this.bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFound("Book not found"));
    }
}
