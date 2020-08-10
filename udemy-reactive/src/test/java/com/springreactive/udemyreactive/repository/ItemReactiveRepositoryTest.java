package com.springreactive.udemyreactive.repository;

import com.springreactive.udemyreactive.document.Item;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SignalType;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Level;

@DataMongoTest
@ExtendWith(SpringExtension.class)
//https://stackoverflow.com/questions/49990340/why-does-my-flapdoodle-embedded-mongodb-test-fail-to-run-creating-embeddedmon
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@DirtiesContext
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ItemReactiveRepositoryTest {
    @Autowired
    ItemReactiveRepository itemReactiveRepository;
    List<Item> itemList = Arrays.asList(
            Item.builder().description("Samsung TV").price(120.00).build(),
            Item.builder().description("Iphone 11").price(160.44).build(),
            Item.builder().description("Frizer LG").price(100.11).build(),
            Item.builder().description("Watch TV").price(120.00).build(),
            Item.builder().id("ABC").description("Headphone").price(11.00).build()
    );

    @BeforeEach
    void setUp() {
        itemReactiveRepository.deleteAll()
                .thenMany(Flux.fromIterable(itemList)
                        .flatMap(item -> itemReactiveRepository.save(item))
                        .doOnNext(item -> System.out.println("Insert Item is: " + item)))
                .blockLast();

    }

    @Test
    void getAllItems() {
        StepVerifier.create(itemReactiveRepository.findAll())
                .expectSubscription()
                .expectNextCount(5)
                .verifyComplete();
    }

    @Test
    void getItemById() {
        StepVerifier.create(itemReactiveRepository.findById("ABC"))
                .expectSubscription()
                .expectNextMatches(item -> item.getDescription().equals("Headphone"))
                .verifyComplete();
    }

    @Test
    void findItemByDesc() {
        StepVerifier.create(itemReactiveRepository.findByDescription("Iphone 11").log())
                .expectSubscription()
                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    void saveItem() {
        Mono<Item> saved = itemReactiveRepository.save(Item
                .builder()
                .description("Google Home Mini")
                .price(30.00)
                .build());

        StepVerifier.create(saved.log("saved : "))
                .expectSubscription()
                .expectNextMatches(item ->
                        item.getDescription().equals("Google Home Mini") &&
                                item.getId() != null
                )
                .verifyComplete();
    }

    @Test
    void updateItem() {
        Flux<Item> updatedItem = itemReactiveRepository.findByDescription("Samsung TV")
                .map(item -> {
                    item.setPrice(21.21);
                    return item;
                })
                .flatMap(item -> itemReactiveRepository.save(item));

        StepVerifier.create(updatedItem.log("updated : "))
                .expectSubscription()
                .expectNextMatches(item -> item.getPrice() == 21.21)
                .verifyComplete();
    }

    @Test
    void deleteItemById() {
        Mono<Void> deleted = itemReactiveRepository.findById("ABC")
                .map(Item::getId)
                .flatMap(id -> itemReactiveRepository.deleteById(id));

        StepVerifier.create(deleted.log("deleted :", Level.INFO, SignalType.ON_COMPLETE))
                .expectSubscription()
                .verifyComplete();

        StepVerifier.create(itemReactiveRepository.findAll().log("New Item list : "))
                .expectNextCount(4)
                .verifyComplete();
    }

    @Test
    void deleteItemByIdA() {
        Mono<Void> deleted = itemReactiveRepository.findById("ABC")
                .flatMap(item -> itemReactiveRepository.delete(item));

        StepVerifier.create(deleted.log("deleted :", Level.INFO, SignalType.ON_COMPLETE))
                .expectSubscription()
                .verifyComplete();

        StepVerifier.create(itemReactiveRepository.findAll().log("New Item list : "))
                .expectNextCount(4)
                .verifyComplete();
    }
}