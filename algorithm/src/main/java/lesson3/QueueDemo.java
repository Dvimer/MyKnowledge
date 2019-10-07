package lesson3;

import java.util.stream.IntStream;

public class QueueDemo {
    public static void main(String[] args) {
        Queue queue = new Queue(10);
        IntStream.range(1, 11).forEach(queue::insert);
        while (!queue.isEmpty()) {
            System.out.print(queue.remove() + " ");
        }
        System.out.println();
    }
}
