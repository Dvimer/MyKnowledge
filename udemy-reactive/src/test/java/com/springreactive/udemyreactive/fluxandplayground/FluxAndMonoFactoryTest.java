package com.springreactive.udemyreactive.fluxandplayground;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

class FluxAndMonoFactoryTest {

    List<String> names = Arrays.asList("adam", "anna", "jack", "jenny");

    @Test
    void fluxUsingIterable() {
        StepVerifier.create(Flux.fromIterable(names))
                .expectNext("adam", "anna", "jack", "jenny")
                .verifyComplete();

    }

    @Test
    void fluxUsingArray() {
        String[] strings = {"adam", "anna", "jack", "jenny"};
        StepVerifier.create(Flux.fromArray(strings))
                .expectNext("adam", "anna", "jack", "jenny")
                .verifyComplete();
    }

    @Test
    void fluxUsingStream() {
        Stream<String> namesStream = Stream.of("adam", "anna", "jack", "jenny");
        StepVerifier.create(Flux.fromStream(namesStream))
                .expectNext("adam", "anna", "jack", "jenny")
                .verifyComplete();
    }

    @Test
    void monoUsingJustOrEmpty() {
        Mono<String> mono = Mono.justOrEmpty(null);

        StepVerifier.create(mono.log())
                .verifyComplete();
    }

    @Test
    void moniUsingSupplier() {
        Supplier<String> adamSupplier = () -> "Adam";
        Mono<String> mono = Mono.fromSupplier(adamSupplier);

        StepVerifier.create(mono.log())
                .expectNext(adamSupplier.get())
                .verifyComplete();
    }

    @Test
    void fluxUsingRange() {
        Flux<Integer> integerFlux = Flux.range(1, 5).log();
        StepVerifier.create(integerFlux)
                .expectNext(1, 2, 3, 4, 5)
                .verifyComplete();
    }
}
