package ru.dvimer.catalizator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.dvimer.catalizator.domain.Message;
import ru.dvimer.catalizator.service.MessageService;

import java.time.Duration;

@RestController
@RequiredArgsConstructor
@RequestMapping("/controller")
public class MainController {
    private final MessageService messageService;

    @GetMapping
    public Flux<Message> listMessage(@RequestParam(defaultValue = "0") Long start, @RequestParam(defaultValue = "3") Long count) {
        return messageService.getMessages()
                .skip(start)
                .take(count);
    }


    @GetMapping("/log")
    public Mono<Void> startLog() {
        messageService.getMessages()
                .delayElements(Duration.ofMillis(1000))
                .doOnNext(System.out::println)
                .doOnNext(System.out::println)
                .doOnNext(System.out::println)
                .subscribe();
        return Mono.empty();
    }

    @PostMapping
    public Mono<Message> createMessage(@RequestBody Message message) {
        return messageService.create(message).log();
    }

}
