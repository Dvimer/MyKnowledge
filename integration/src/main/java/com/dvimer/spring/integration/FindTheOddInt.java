package com.dvimer.spring.integration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheOddInt {
    public static int findIt(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();

        Arrays.stream(a).forEach(intNum -> {
            Integer value = map.get(intNum);
            if (value == null) {
                map.put(intNum, 1);
            } else {
                map.put(intNum, ++value);
            }
        });

        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            if (integerIntegerEntry.getValue() % 2 != 0) {
                return integerIntegerEntry.getKey();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findIt(new int[]{20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5}));
//        System.out.println(findIt(new int[]{1, 1, 1, 1, 1, 1,1}));
    }

    public static int findIt1(int[] a) {
        return Arrays.stream(a)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue().size() % 2 == 1)
                .mapToInt(Map.Entry::getKey)
                .findFirst()
                .getAsInt();
    }

}
