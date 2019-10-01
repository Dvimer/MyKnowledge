package com.dvimer.spring.integration;

import java.util.LinkedHashMap;
import java.util.Map;

public class PrimesInNumbers {

    public static void main(String[] args) {
        System.out.println(factors(18195729));
    }

    public static String factors(int n) {
        Map<Integer, Integer> factorials = new LinkedHashMap<>();
        int multiplier = 1;
        for (int i = 2; n != 1; ) {
            if (n % i == 0) {
                multiplier *= i;
                Integer number = factorials.get(i);
                if (number == null) {
                    factorials.put(i, 1);
                } else {
                    factorials.put(i, ++number);
                }
                n = n / i;
                i = 2;
            } else {
                i++;
            }
        }
        return peimer(factorials);
    }

    private static String peimer(Map<Integer, Integer> factorials) {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : factorials.entrySet()) {
            if (entry.getValue() > 1) {
                builder.append("(" + entry.getKey() + "**" + entry.getValue() + ")");
            } else if (entry.getValue() == 1) {
                builder.append("(" + entry.getKey() + ")");
            }
        }
        return builder.toString();
    }
}
