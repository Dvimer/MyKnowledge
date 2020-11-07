package chapter8;


import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ParallerTask<T> {

    public <T> Collection<T> getParallerResults(List<Node<T>> nodes) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ConcurrentLinkedQueue<T> resultQueue = new ConcurrentLinkedQueue<>();
        parallelRecursive(executorService, nodes, resultQueue);
        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
        return resultQueue;
    }

    private <T> void parallelRecursive(ExecutorService executorService, List<Node<T>> nodes, ConcurrentLinkedQueue<T> resultQueue) {
        for (Node<T> node : nodes) {
            executorService.execute(() -> resultQueue.add(node.compute()));
            parallelRecursive(executorService, node.getChildren(), resultQueue);
        }

    }
}

class Node<T> {

    public T compute() {
        return null;
    }

    public List<Node<T>> getChildren() {
        return null;
    }
}