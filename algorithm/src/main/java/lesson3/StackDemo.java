package lesson3;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StackDemo {
    public static void main(String[] args) {
        revertIntegerLine();

        revertWorld("Hello World");
    }

    private static void revertIntegerLine() {
        Stack<Integer> stack = new Stack(Integer.class, 10);
        IntStream.range(1, 11).forEach(stack::insert);

        while (!stack.isEmpty()) {
            System.out.print(stack.remove());
        }
        System.out.println();
    }

    private static void revertWorld(String words) {
        Stack<String> stackSting = new Stack(String.class, words.length());
        Arrays.stream(words.split("")).forEach(stackSting::insert);

        while (!stackSting.isEmpty()) {
            System.out.print(stackSting.remove());
        }
        System.out.println();
    }
}
