package ru.dvimer.spring5learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dvimer.spring5learn.domain.Book;
import ru.dvimer.spring5learn.domain.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
