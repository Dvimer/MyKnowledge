package thread.deamons;

import java.util.concurrent.TimeUnit;

public class SimpleDeamons implements Runnable {
    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(100);
            System.out.println(Thread.currentThread() + " " + this);
        } catch (InterruptedException e) {
            System.out.println("sleep() interrupted");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread deamon = new Thread(new SimpleDeamons());
            deamon.setDaemon(true);
            deamon.start();
        }
        System.out.println("All deamonts started");
        TimeUnit.MILLISECONDS.sleep(175);
    }
}
