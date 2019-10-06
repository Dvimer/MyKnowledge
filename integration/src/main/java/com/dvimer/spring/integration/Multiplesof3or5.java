package com.dvimer.spring.integration;

import java.util.stream.IntStream;

public class Multiplesof3or5 {
    public static void main(String[] args) {

        System.out.println(solution(15));
        System.out.println(solution(5));
        System.out.println(solution(2));
        System.out.println(solution(8));
        System.out.println(solution(10));
    }

    public static int solution(int number) {

        return IntStream.range(0, number)
                .filter(p -> p % 3 == 0 || p % 5 == 0)
                .sum();
    }

}