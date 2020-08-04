package com.springreactive.udemyreactive.fluxandplayground;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;

public class FluxAndMonoWithTImeTest {
    @Test
    void infiniteSequence() throws InterruptedException {
        Flux<Long> infiniteFlux = Flux.interval(Duration.ofMillis(200)).log();


        infiniteFlux.subscribe(element -> System.out.println("Value is : " + element));
        Thread.sleep(3000);
    }

    @Test
    void infiniteSequenceTest() throws InterruptedException {
        Flux<Long> infiniteFlux = Flux.interval(Duration.ofMillis(200))
                .skip(1)
                .take(3)
                .log();

        StepVerifier.create(infiniteFlux)
                .expectSubscription()
                .expectNext(1L, 2L, 3L)
                .verifyComplete();
    }

    @Test
    void infiniteSequenceMap() throws InterruptedException {
        Flux<Integer> infiniteFlux = Flux.interval(Duration.ofMillis(200))
                .map(Long::intValue)
                .take(3)
                .log();

        StepVerifier.create(infiniteFlux)
                .expectSubscription()
                .expectNext(0, 1, 2)
                .verifyComplete();
    }

    @Test
    void infiniteSequenceMap_withDelay() throws InterruptedException {
        Flux<Integer> infiniteFlux = Flux.interval(Duration.ofMillis(200))
                .delayElements(Duration.ofSeconds(1))
                .map(Long::intValue)
                .take(3)
                .log();

        StepVerifier.create(infiniteFlux)
                .expectSubscription()
                .expectNext(0, 1, 2)
                .verifyComplete();
    }
}
