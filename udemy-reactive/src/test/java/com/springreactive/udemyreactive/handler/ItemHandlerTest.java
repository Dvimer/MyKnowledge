package com.springreactive.udemyreactive.handler;

import com.springreactive.udemyreactive.constants.ItemConstants;
import com.springreactive.udemyreactive.document.Item;
import com.springreactive.udemyreactive.repository.ItemReactiveRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext
@AutoConfigureWebTestClient
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActiveProfiles("test")
class ItemHandlerTest {
    @Autowired
    WebTestClient webTestClient;
    @Autowired
    ItemReactiveRepository itemReactiveRepository;
    List<Item> items = Arrays.asList(
            Item.builder().description("Samsung").price(111.11).build(),
            Item.builder().description("Apple").price(123.11).build(),
            Item.builder().description("Lg").price(123.33).build(),
            Item.builder().description("Hair").price(123.44).build(),
            Item.builder().id("ABC").description("Xiaomi").price(123.55).build()
    );

    @BeforeAll
    void setUp() {
        itemReactiveRepository.deleteAll()
                .thenMany(Flux.fromIterable(items))
                .flatMap(item -> itemReactiveRepository.save(item))
                .doOnNext(item -> System.out.println("Inserted item is: " + item))
                .blockLast();
    }

    @Test
    void getAllItems() {
        webTestClient.get()
                .uri(ItemConstants.ITEM_FUNCTIONAL_END_POINT)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Item.class)
                .hasSize(5);
    }

    @Test
    void getAllItems_approach2() {
        webTestClient.get()
                .uri(ItemConstants.ITEM_FUNCTIONAL_END_POINT)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Item.class)
                .hasSize(5)
                .consumeWith(respose -> {
                    List<Item> items = respose.getResponseBody();
                    assert (items) != null;
                    for (Item item : items) {
                        assertNotNull(item.getId());
                    }
                });
    }

    @Test
    void getAllItems_approach3() {
        Flux<Item> responseBody = webTestClient.get()
                .uri(ItemConstants.ITEM_FUNCTIONAL_END_POINT)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .returnResult(Item.class)
                .getResponseBody();

        StepVerifier.create(responseBody.log("Value from network : "))
                .expectSubscription()
                .expectNextCount(5)
                .verifyComplete();
    }

}