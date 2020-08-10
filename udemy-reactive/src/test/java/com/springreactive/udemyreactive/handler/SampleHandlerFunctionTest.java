package com.springreactive.udemyreactive.handler;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureWebTestClient
@DirtiesContext
class SampleHandlerFunctionTest {
    @Autowired
    WebTestClient webTestClient;

    @Test
    void flux_approach1() {
        Flux<Integer> fluxBody = webTestClient.get().uri("/functional/flux")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .returnResult(Integer.class)
                .getResponseBody();

        StepVerifier.create(fluxBody)
                .expectSubscription()
                .thenAwait(Duration.ofSeconds(4))
                .expectNext(1, 2, 3, 4)
                .verifyComplete();
    }

    @Test
    void mono() {
        webTestClient.get().uri("/functional/mono")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Integer.class)
                .consumeWith(consume -> {
                    assertEquals("body", consume.getResponseBody(), 1);
                });
    }

}