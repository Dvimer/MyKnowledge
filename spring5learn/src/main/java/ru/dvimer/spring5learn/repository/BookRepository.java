package ru.dvimer.spring5learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dvimer.spring5learn.domain.Author;
import ru.dvimer.spring5learn.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
