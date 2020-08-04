package com.springreactive.udemyreactive.fluxandplayground;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

class FluxTest {
    @Test
    void fluxText() {
        Flux<String> springFlux = Flux
                .just("Spring", "Spring boot", "Reactive Spring")
                .concatWith(Flux.error(new RuntimeException("Exception Occured")))
                .concatWith(Flux.just("After Error"))
                .log("onError");
        springFlux
                .subscribe(System.out::println,
                        System.err::println,
                        () -> System.out.println("Completed"));
    }

    @Test
    void fluxTextNext() {
        Flux<String> springFlux = Flux
                .just("Spring", "Spring boot", "Reactive Spring")
                .log();

        StepVerifier.create(springFlux)
                .expectNext("Spring", "Spring boot", "Reactive Spring")
                .verifyComplete();
    }

    @Test
    void fluxTestElementsWithoutError() {
        Flux<String> springFlux = Flux
                .just("Spring", "Spring boot", "Reactive Spring")
                .log();
        StepVerifier.create(springFlux)
                .expectNext("Spring")
                .expectNext("Spring boot")
                .expectNext("Reactive Spring")
                .verifyComplete();
    }

    @Test
    void fluxTestElementsWitError() {
        Flux<String> springFlux = Flux
                .just("Spring", "Spring boot", "Reactive Spring")
                .concatWith(Flux.error(new RuntimeException("Exception Occured")))
                .log();
        StepVerifier.create(springFlux)
                .expectNext("Spring")
                .expectNext("Spring boot")
                .expectNext("Reactive Spring")
//                .expectError(RuntimeException.class)
                .expectErrorMessage("Exception Occured")
                .verify();
    }

    @Test
    void fluxTestElementsCount() {
        Flux<String> springFlux = Flux
                .just("Spring", "Spring boot", "Reactive Spring")
                .concatWith(Flux.error(new RuntimeException("Exception Occured")))
                .log();
        StepVerifier.create(springFlux)
                .expectNextCount(3)
//                .expectError(RuntimeException.class)
                .expectErrorMessage("Exception Occured")
                .verify();
    }

}
