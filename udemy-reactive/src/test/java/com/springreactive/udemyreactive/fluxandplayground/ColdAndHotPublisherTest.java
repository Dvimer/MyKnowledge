package com.springreactive.udemyreactive.fluxandplayground;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;

import java.time.Duration;

class ColdAndHotPublisherTest {
    @Test
    void coldPublisherTest() throws InterruptedException {
        Flux<String> stringFlux = Flux.just("A", "B", "C", "D", "E", "F")
                .delayElements(Duration.ofSeconds(1));

        stringFlux.subscribe(p -> System.out.println("Subscriber 1 :" + p));
        Thread.sleep(2000);
        stringFlux.subscribe(p -> System.out.println("Subscriber 2 :" + p));
        Thread.sleep(2000);
        stringFlux.subscribe(p -> System.out.println("Subscriber 3 :" + p));
        Thread.sleep(6000);
    }

    @Test
    void hotPublisherTest() throws InterruptedException {
        Flux<String> stringFlux = Flux.just("A", "B", "C", "D", "E", "F")
                .delayElements(Duration.ofSeconds(1));

        ConnectableFlux<String> connectableFlux = stringFlux.publish();
        connectableFlux.connect();
        connectableFlux.subscribe(p -> System.out.println("Subscriber 1 :" + p));
        Thread.sleep(3000);
        connectableFlux.subscribe(p -> System.out.println("Subscriber 2 :" + p));
        Thread.sleep(4000);
        connectableFlux.subscribe(p -> System.out.println("Subscriber 3 :" + p));
        Thread.sleep(3000);

    }
}
