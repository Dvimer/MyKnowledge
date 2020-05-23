package ru.dvimer.spring5learn.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dvimer.spring5learn.domain.Book;
import ru.dvimer.spring5learn.repository.BookRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
