package chapter5;

import java.util.concurrent.CountDownLatch;

public class TestHarness {
    public static void main(String[] args) throws InterruptedException {

        int nThread = 10;
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch stopGate = new CountDownLatch(nThread);

        Runnable runnable = () -> {
            System.out.println("12");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };


        for (int i = 0; i < nThread; i++) {
            Thread thread = new Thread(() -> {
                try {
                    startGate.await();
                    try {
                        runnable.run();
                    } finally {
                        stopGate.countDown();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }

        long start = System.nanoTime();
        startGate.countDown();
        stopGate.await();
        long end = System.nanoTime();
        System.out.println(end - start);
    }
}

