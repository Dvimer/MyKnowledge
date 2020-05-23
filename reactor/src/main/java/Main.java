import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Flux<String> seq1 = Flux.just("foo", "bar", "foobar");
        List<String> list = Arrays.asList("foo", "bar", "foobar");

        Flux<String> stringFlux = Flux.fromIterable(list);

        Mono<String> noData = Mono.empty();

        Mono<String> data = Mono.just("foo");

        Flux<Integer> numbersFromFiveToSeven = Flux.range(5, 3);
        stringFlux.subscribe();

//        Flux<Integer> ints = Flux.range(1, 5)
//                .map(i -> {
//                    if (i != 3) return i;
//                    throw new RuntimeException("Got to 4");
//                });
//        ints.subscribe(System.out::println, error -> System.err.println("Error: " + error));

//        showForParametrSubscribed();


//        useBaseSubscribe();
//        Flux.range(1, 3)
//                .doOnRequest(r -> System.out.println(r))
//                .subscribe();
//        backPressure();
        Flux<Integer> range = Flux.range(1, 10);

//                .doOnEach(p -> {
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                })


        Flux.generate(() -> 1, (state, sink) -> {
            sink.next("3 x " + state + " = " + 3 * state);
            if (state == 10) sink.complete();
            return state + 1;
        }, state -> System.out.println("State = " + state)).subscribe(System.out::println);

    }

    private static void backPressure() {
        Flux.range(1, 10)
                .doOnRequest(r -> System.out.println("request of " + r))
                .subscribe(new BaseSubscriber<Integer>() {

                    @Override
                    public void hookOnSubscribe(Subscription subscription) {
                        request(1);
                    }

                    @Override
                    public void hookOnNext(Integer integer) {
//                        System.out.println("Cancelling after having received " + integer);
//                        cancel();
                        System.out.println(integer);
                        request(1);
                    }
                });
    }

    private static void useBaseSubscribe() {
        Flux.range(1, 4)
                .subscribe(new SampleSubscriber<>());
    }

    private static void showForParametrSubscribed() {
        Flux<Integer> range = Flux.range(1, 14);
        range.subscribe(System.out::println,
                error -> System.out.println("Error " + error),
                () -> System.out.println("Done"),
                sub -> sub.request(10));
    }
}
