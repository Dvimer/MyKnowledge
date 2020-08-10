package com.springreactive.udemyreactive.initialize;

import com.springreactive.udemyreactive.document.Item;
import com.springreactive.udemyreactive.repository.ItemReactiveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
@Profile("!test")
public class ItemDataInitializer implements CommandLineRunner {

    private final ItemReactiveRepository itemReactiveRepository;

    @Override
    public void run(String... args) throws Exception {
        initialDataSetUp();
    }

    private void initialDataSetUp() {
        List<Item> items = Arrays.asList(
                Item.builder().description("Samsung").price(111.11).build(),
                Item.builder().description("Apple").price(123.11).build(),
                Item.builder().description("Lg").price(123.33).build(),
                Item.builder().description("Hair").price(123.44).build(),
                Item.builder().description("Xiaomi").price(123.55).build()
        );
        itemReactiveRepository.deleteAll()
                .thenMany(Flux.fromIterable(items))
                .flatMap(itemReactiveRepository::save)
                .thenMany(itemReactiveRepository.findAll())
                .subscribe(item -> System.out.println("Item inverted from CommandLine:" + item));
    }
}
