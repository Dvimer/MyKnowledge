package thread.banktellsimulation;

import java.util.concurrent.ArrayBlockingQueue;

public class CustomerLine extends ArrayBlockingQueue<Customer> {
    public CustomerLine(int capacity) {
        super(capacity);
    }

    @Override
    public String toString() {
        if (this.size() == 0) {
            return "[Empty]";
        }
        StringBuilder builder = new StringBuilder();
        for (Customer customer : this) {
            builder.append(customer);
        }
        return builder.toString();
    }
}
