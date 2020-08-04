package com.springreactive.udemyreactive.fluxandplayground;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

class MonoTest {
    @Test
    void monoTest() {
        Mono<String> springMono = Mono.just("Spring");
        StepVerifier.create(springMono)
                .expectNext("Spring")
                .verifyComplete();
    }

    @Test
    void monoTest_Error() {
        StepVerifier
                .create(Mono.error(new RuntimeException("Exception Occurred")))
                .expectError(RuntimeException.class)
                .verify();
    }
}
