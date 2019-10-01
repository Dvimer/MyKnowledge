package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Restaurant {
    Meal meal;
    ExecutorService exec = Executors.newCachedThreadPool();
    final WaitPerson waitPerson = new WaitPerson(this);
    final Cheaf cheaf = new Cheaf(this);

    public Restaurant() {
        exec.execute(cheaf);
        exec.execute(waitPerson);
    }

    public static void main(String[] args) {
        new Restaurant();
    }
}

class Meal {
    private final int orderNum;

    public Meal(int orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "Meal " + orderNum;
    }
}

class WaitPerson implements Runnable {
    private Restaurant restaurant;

    public WaitPerson(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal == null) {
                        wait();
                    }
                }
                System.out.println("Waitperson got " + restaurant.meal);
                synchronized (restaurant.cheaf) {
                    restaurant.meal = null;
                    restaurant.cheaf.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("WaitPerson interrupted");
        }
    }
}

class Cheaf implements Runnable {
    private Restaurant restaurant;
    private int count = 0;

    public Cheaf(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal != null) {
                        wait();
                    }
                }
                if (++count == 10) {
                    System.out.println("Out of food, closing");
                    restaurant.exec.shutdown();
                }
                System.out.println("Order up ");
                synchronized (restaurant.waitPerson) {
                    restaurant.meal = new Meal(count);
                    restaurant.waitPerson.notifyAll();
                }
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("Chef interrupted");
        }
    }
}