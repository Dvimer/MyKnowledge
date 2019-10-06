package com.dvimer.spring.integration;

import java.util.Arrays;
import java.util.stream.Collectors;

public class FindNumbersWhichAreDivisibleByGivenNumber {
    public static void main(String[] args) {

    }

    public static int[] divisibleBy(int[] numbers, int divider) {
        return Arrays.stream(numbers).filter(num -> num % divider == 0).toArray();
    }
}
