package thread.banktellsimulation;

import java.util.concurrent.TimeUnit;

public class Teller implements Runnable, Comparable<Teller> {
    private static int counter = 0;
    private final int id = counter++;
    private int customerServed = 0;
    private CustomerLine customers;
    private boolean servingCustomerLine = true;

    public Teller(CustomerLine customers) {
        this.customers = customers;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Customer customer = customers.take();
                TimeUnit.MILLISECONDS.sleep(customer.getServiceTime());
                synchronized (this) {
                    customerServed++;
                    while (!servingCustomerLine) {
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println(this + " interrupted");
        }
        System.out.println(this + " terminating");
    }

    public synchronized void doSomthingElse() {
        customerServed = 0;
        servingCustomerLine = false;
    }

    public synchronized void serveCustomerLine() {
        assert !servingCustomerLine : "already serving : " + this;
        servingCustomerLine = true;
        notifyAll();
    }

    @Override
    public String toString() {
        return "Teller " + id + " ";
    }

    public String shortString() {
        return "T" + id;
    }

    @Override
    public synchronized int compareTo(Teller o) {
        return Integer.compare(customerServed, o.customerServed);
    }
}
