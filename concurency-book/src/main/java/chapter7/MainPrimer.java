package chapter7;

public class MainPrimer {
    public static void main(String[] args) throws InterruptedException {
        PrimerGenerator generator = new PrimerGenerator();
        new Thread(generator).start();
        try {
            Thread.sleep(100);
        } finally {
            generator.cancel();
        }
        generator.getNumbers().forEach(System.out::println);
    }
}
