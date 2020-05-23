package ru.dvimer.spring5learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dvimer.spring5learn.domain.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
