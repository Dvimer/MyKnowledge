package ru.dvimer.spring5learn.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dvimer.spring5learn.domain.Author;
import ru.dvimer.spring5learn.domain.Book;
import ru.dvimer.spring5learn.repository.AuthorRepository;
import ru.dvimer.spring5learn.repository.BookRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    public List<Author> findAll() {
        return authorRepository.findAll();
    }
}
