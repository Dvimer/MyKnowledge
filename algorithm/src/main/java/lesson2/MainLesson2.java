package lesson2;

import java.util.function.Consumer;

public class MainLesson2 {
    public static void main(String[] args) {
        testSort(NewArray::bubbleSort);
        testSort(NewArray::selectSort);
        testSort(NewArray::sortInsert);
    }

    private static void testSort(Consumer<NewArray> arrayConsumer) {
        NewArray array = new NewArray(10000, true);
        long start = System.currentTimeMillis();
//        array.display();
        arrayConsumer.accept(array);
//        array.display();
        long finish = System.currentTimeMillis();
        System.out.println("All time = " + (finish - start));
    }
}
