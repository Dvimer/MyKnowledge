package com.springreactive.udemyreactive.fluxandplayground;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;

import static reactor.core.scheduler.Schedulers.parallel;

class FluxAndMonoTransformTest {
    List<String> names = Arrays.asList("adam", "anna", "jack", "jenny");

    @Test
    void transformUsingMap() {
        Flux<String> nameFlux = Flux.fromIterable(names)
                .map(String::toUpperCase)
                .log();

        StepVerifier.create(nameFlux)
                .expectNext("ADAM", "ANNA", "JACK", "JENNY")
                .verifyComplete();
    }

    @Test
    void transformUsingMap_Length_repeat() {
        Flux<Integer> nameFlux = Flux.fromIterable(names)
                .map(String::length)
                .repeat(1)
                .log();

        StepVerifier.create(nameFlux)
                .expectNext(4, 4, 4, 5, 4, 4, 4, 5)
                .verifyComplete();
    }

    @Test
    void transformUsingMap_filter() {
        Flux<String> nameFlux = Flux.fromIterable(names)
                .filter(p -> p.length() > 4)
                .map(String::toUpperCase)
                .repeat(2)
                .log();

        StepVerifier.create(nameFlux)
                .expectNext("JENNY", "JENNY", "JENNY")
                .verifyComplete();
    }

    @Test
    void ransformUsingFlatMap() {
        Flux<String> stringFlux = Flux.fromIterable(Arrays.asList("A", "B", "C", "D", "E", "F"))
                .flatMap(p -> Flux.fromIterable(convertToList(p)))
                .log();

        StepVerifier.create(stringFlux)
                .expectNextCount(12)
                .verifyComplete();

    }

    private List<String> convertToList(String character) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Arrays.asList(character, "newValue");
    }

    @Test
    void ransformUsingFlatMap_usingParallel() {
        Flux<String> stringFlux = Flux.fromIterable(Arrays.asList("A", "B", "C", "D", "E", "F"))
                .window(2)
                .flatMap(p ->
                        p.map(this::convertToList).subscribeOn(parallel())
                                .flatMap(Flux::fromIterable)
                )
                .log();

        StepVerifier.create(stringFlux)
                .expectNextCount(12)
                .verifyComplete();

    }

    @Test
    void ransformUsingFlatMap_parallel_maintain_order() {
        Flux<String> stringFlux = Flux.fromIterable(Arrays.asList("A", "B", "C", "D", "E", "F"))
                .window(2)
//                .concatMap(p ->
//                        p.map(this::convertToList).subscribeOn(parallel())
//                                .flatMap(Flux::fromIterable)
//                )
                .flatMapSequential(p ->
                        p.map(this::convertToList).subscribeOn(parallel())
                                .flatMap(Flux::fromIterable)
                )

                .log();

        StepVerifier.create(stringFlux)
                .expectNextCount(12)
                .verifyComplete();

    }

}
