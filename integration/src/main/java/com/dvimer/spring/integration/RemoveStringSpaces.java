package com.dvimer.spring.integration;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RemoveStringSpaces {
    public static void main(String[] args) {


        long start = System.currentTimeMillis();
        System.out.println(noSpace("8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd"));

        long finish = System.currentTimeMillis();

        System.out.println("Result = " + (finish - start));

        start = System.currentTimeMillis();
        System.out.println(noSpace1("8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd"));

        finish = System.currentTimeMillis();

        System.out.println("Result = " + (finish - start));


    }

    static String noSpace(final String x) {
        return Arrays.stream(x.split(" ")).collect(Collectors.joining());
    }

    static String noSpace1(final String x) {
        return x.replaceAll(" ", "");
    }
}
