//package chapter7;
//
//import java.math.BigInteger;
//import java.util.Set;
//import java.util.concurrent.BlockingQueue;
//
//public class PrimerGeneratorProducer extends Thread {
//
//    private final BlockingQueue<BigInteger> numbers;
//
//    public PrimerGeneratorProducer(BlockingQueue<BigInteger> numbers) {
//        this.numbers = numbers;
//    }
//
//
//    @Override
//    public void run() {
//        BigInteger number = BigInteger.ONE;
//        while (!Thread.currentThread().isInterrupted()) {
//            try {
//                numbers.add(number = number.nextProbablePrime());
//            } catch (InterruptedException e) {
//
//            }
//
//        }
//    }
//
//    public void cancel() {
//        interrupt();
//    }
//
//    public synchronized Set<BigInteger> getNumbers() {
//        return numbers;
//    }
//}
