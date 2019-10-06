package com.dvimer.spring.integration;

import java.util.Arrays;
import java.util.stream.Stream;

public class ArrayplusArray {

    public static void main(String[] args) {
        System.out.println(arrayPlusArray(new int[]{1, 2, 3}, new int[]{4, 5, 6}));
        System.out.println(arrayPlusArray(new int[]{-1, -2, -3}, new int[]{-4, -5, -6}));
        System.out.println(arrayPlusArray(new int[]{0, 0, 0}, new int[]{4, 5, 6}));
        System.out.println(arrayPlusArray(new int[]{100, 200, 300}, new int[]{400, 500, 600}));
    }

    public static int arrayPlusArray(int[] arr1, int[] arr2) {
        return Stream.of(arr1, arr2).flatMapToInt(Arrays::stream).sum();
    }
}
