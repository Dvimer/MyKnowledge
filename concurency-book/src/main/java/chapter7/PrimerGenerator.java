package chapter7;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class PrimerGenerator implements Runnable {

    private transient boolean canceled;
    private Set<BigInteger> numbers = new HashSet<>();

    @Override
    public void run() {
        BigInteger number = BigInteger.ONE;
        while (!canceled) {
            number = number.nextProbablePrime();
            synchronized (this) {
                numbers.add(number);
            }
        }
    }

    public void cancel() {
        canceled = true;
    }

    public synchronized Set<BigInteger> getNumbers() {
        return numbers;
    }
}
