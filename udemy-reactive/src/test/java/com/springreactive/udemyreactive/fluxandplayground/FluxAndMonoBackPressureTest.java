package com.springreactive.udemyreactive.fluxandplayground;

import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

class FluxAndMonoBackPressureTest {
    @Test
    void backPressureTest() {
        Flux<Integer> finiteFlux = Flux.range(1, 10).log();

        StepVerifier.create(finiteFlux)
                .expectSubscription()
                .thenRequest(1)
                .expectNext(1)
                .thenRequest(1)
                .expectNext(2)
                .thenRequest(1)
                .expectNext(3)
                .thenCancel()
                .verify();

    }

    @Test
    void backPressure() {
        Flux<Integer> finiteFlux = Flux.range(1, 10).log();
        finiteFlux.subscribe(
                e -> System.out.println("Element is :" + e),
                e -> System.out.println("Error is :" + e.getMessage()),
                () -> System.out.println("Complete"),
                subscription -> subscription.request(2)
        );
    }

    @Test
    void backPressure_cancel() {
        Flux<Integer> finiteFlux = Flux.range(1, 10).log();
        finiteFlux.subscribe(
                e -> System.out.println("Element is :" + e),
                e -> System.out.println("Error is :" + e.getMessage()),
                () -> System.out.println("Complete"),
                Subscription::cancel
        );
    }

    @Test
    void customized_backPressure() {
        Flux<Integer> finiteFlux = Flux.range(1, 10).log();
        finiteFlux.subscribe(new BaseSubscriber<Integer>() {
            @Override
            protected void hookOnNext(Integer value) {
                System.out.println("Value received is: " + value);
                if (value == 4) {
                    cancel();
                }
                request(1);
            }
        });
    }
}
