package com.springreactive.udemyreactive.controller.v1;

import com.springreactive.udemyreactive.document.Item;
import com.springreactive.udemyreactive.repository.ItemReactiveRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.springreactive.udemyreactive.constants.ItemConstants.ITEM_END_POINT;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ItemController {
    private final ItemReactiveRepository itemRepository;

    @GetMapping(ITEM_END_POINT)
    public Flux<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @GetMapping(ITEM_END_POINT + "/{id}")
    public Mono<ResponseEntity<Item>> getItemById(@PathVariable String id) {
        return itemRepository.findById(id)
                .map(item -> new ResponseEntity<>(item, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(ITEM_END_POINT)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Item> createItem(@RequestBody Item item) {
        return itemRepository.save(item);
    }

    @DeleteMapping(ITEM_END_POINT + "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteItem(@PathVariable String id) {
        return itemRepository.deleteById(id);
    }

    @PutMapping(ITEM_END_POINT + "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<ResponseEntity<Item>> updateItem(@PathVariable String id, @RequestBody Item item) {
        return itemRepository.findById(id)
                .flatMap(currentItem -> {
                    currentItem.setDescription(item.getDescription());
                    currentItem.setPrice(item.getPrice());
                    return itemRepository.save(currentItem);
                })
                .map(savedItem -> new ResponseEntity<>(savedItem, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
