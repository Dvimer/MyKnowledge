package letscode;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        CountDownLatch countDownLatch = new CountDownLatch(2);

//        Flux<Integer> range = Flux.fromIterable(List.of(1,2,3,4,5,6,7,8,9,324));
//        range
////                .delayElements(Duration.ofMillis(100))
////                .doOnNext(p -> System.out.println("Do on next 1"))
////                .doOnNext(p -> System.out.println(Thread.currentThread().getName()))
//                .doOnComplete(() -> System.out.println("Complite 1"))
//                .log("onNext")
////                .doOnComplete(countDownLatch::countDown)
//                .subscribe(System.out::println);
//
//        Thread.sleep(1000);

        Flux<String> flux = Flux.just("A");
        Flux<String> map = flux.map(s -> "foo" + s);
        map.subscribe(System.out::println);

        Flux.interval(Duration.ofMillis(100)).take(10);
//        Consumer

        String[][] field = new String[10][10];
        for (String[] row : field) {
            Arrays.fill(row, "*");
        }

        for (String[] row : field) {
            for (String column : row) {
                System.out.print(column + " ");
            }
            System.out.println();
        }

        Flux<String> first = Flux.just("53453", "543534");
        Flux<String> second = Flux.just("53453", "543534");

        first.conc(second);
    }
}
