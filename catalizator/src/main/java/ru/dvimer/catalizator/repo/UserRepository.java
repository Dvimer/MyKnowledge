package ru.dvimer.catalizator.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;
import ru.dvimer.catalizator.domain.Message;
import ru.dvimer.catalizator.domain.User;

public interface UserRepository extends ReactiveCrudRepository<User, Long> {
    Mono<User> findByUsername(String userName);
}
