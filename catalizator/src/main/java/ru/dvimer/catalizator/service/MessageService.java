package ru.dvimer.catalizator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.dvimer.catalizator.domain.Message;
import ru.dvimer.catalizator.repo.MessageRepository;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    public Flux<Message> getMessages() {
        return messageRepository.findAll();
    }

    public Mono<Message> create(Message message) {
        return messageRepository.save(message);
    }
}
