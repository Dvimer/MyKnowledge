package ru.dvimer.catalizator.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import ru.dvimer.catalizator.domain.Message;

public interface MessageRepository extends ReactiveCrudRepository<Message, Long> {
}
