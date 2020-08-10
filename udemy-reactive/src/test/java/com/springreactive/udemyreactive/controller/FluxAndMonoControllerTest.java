package com.springreactive.udemyreactive.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.test.scheduler.VirtualTimeScheduler;

import java.time.Duration;
import java.util.List;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@ExtendWith(SpringExtension.class)
@WebFluxTest
@DirtiesContext
class FluxAndMonoControllerTest {
    @Autowired
    WebTestClient webTestClient;

    @Test
    void flux_approach1() {
        Flux<Integer> fluxBody = webTestClient.get().uri("/flux")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .returnResult(Integer.class)
                .getResponseBody();

        VirtualTimeScheduler.getOrSet();

        StepVerifier.withVirtualTime(() -> fluxBody)
                .expectSubscription()
                .thenAwait(Duration.ofSeconds(4))
                .expectNext(1, 2, 3, 4)
                .verifyComplete();
    }

    @Test
    void flux_approach2() {
        webTestClient.get().uri("/flux")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(Integer.class)
                .hasSize(4);
    }

    @Test
    void flux_approach3() {

        List<Integer> expectedResult = List.of(1, 2, 3, 4);
        EntityExchangeResult<List<Integer>> listEntityExchangeResult = webTestClient.get().uri("/flux")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(Integer.class)
                .returnResult();

        assertEquals("expected", expectedResult, listEntityExchangeResult.getResponseBody());
    }

    @Test
    void flux_approach4() {

        List<Integer> expectedResult = List.of(1, 2, 3, 4);
        webTestClient.get().uri("/flux")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(Integer.class)
                .consumeWith(responce -> assertEquals("expected", responce.getResponseBody(), expectedResult));

    }

    @Test
    void fluxStream() {
        Flux<Long> longStreamFlux = webTestClient.get().uri("/fluxStream")
                .accept(MediaType.APPLICATION_STREAM_JSON)
                .exchange()
                .expectStatus().isOk()
                .returnResult(Long.class)
                .getResponseBody();

        StepVerifier.create(longStreamFlux.log())
                .expectNext(0L, 1L, 2L)
                .thenCancel()
                .verify();
    }

    @Test
    void mono() {
        webTestClient.get().uri("/mono")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Integer.class)
                .consumeWith(consume -> {
                    assertEquals("body", consume.getResponseBody(), 1222);
                });
    }
}