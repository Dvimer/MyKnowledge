package com.dvimer.spring.integration;

import java.util.ArrayList;
import java.util.function.IntSupplier;

public class ThePaperFoldSequence implements IntSupplier {
    private ArrayList<Integer> integers = new ArrayList<>();
    private int count;
    private int number = 1;


    public int getAsInt() {
        if (integers.isEmpty()) {
            integers.add(1);
        } else if (integers.size() == count) {
            integers = generate(integers);
        }
        return integers.get(count++);
    }

    private ArrayList<Integer> generate(ArrayList<Integer> integers) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (Integer integer : integers) {

            arrayList.add(number);
            arrayList.add(integer);
            number = number == 1 ? 0 : 1;
        }
        number = 1;
        arrayList.add(0);

        return arrayList;
    }


    public static void main(String[] args) {
        ThePaperFoldSequence paperFoldSequence = new ThePaperFoldSequence();
        System.out.print(paperFoldSequence.getAsInt());
        System.out.print(paperFoldSequence.getAsInt());
        System.out.print(paperFoldSequence.getAsInt());
        System.out.print(paperFoldSequence.getAsInt());
        System.out.print(paperFoldSequence.getAsInt());
        System.out.print(paperFoldSequence.getAsInt());
        System.out.print(paperFoldSequence.getAsInt());
        System.out.print(paperFoldSequence.getAsInt());
        System.out.print(paperFoldSequence.getAsInt());
        System.out.print(paperFoldSequence.getAsInt());
        System.out.print(paperFoldSequence.getAsInt());
        System.out.print(paperFoldSequence.getAsInt());
        System.out.print(paperFoldSequence.getAsInt());
        System.out.print(paperFoldSequence.getAsInt());
        System.out.print(paperFoldSequence.getAsInt());
        System.out.print(paperFoldSequence.getAsInt());
    }
}