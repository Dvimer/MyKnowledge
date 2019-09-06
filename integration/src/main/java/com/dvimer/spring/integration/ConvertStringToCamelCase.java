package com.dvimer.spring.integration;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ConvertStringToCamelCase {
    public static void main(String[] args) {

        System.out.println(toCamelCase("the_Stealth_Warrior"));
        System.out.println(toCamelCase("the-Stealth-Warrior"));
        System.out.println(toCamelCase(""));
        System.out.println(toCamelCase("blue_desert_Red_south_Square_Street_Wall_Green_river"));
        System.out.println(toCamelCase("Right_bridge_Street_Samurai_Black_Ninja_right_Yellow_Wall"));

    }

    public static String toCamelCase(String s) {
        String[] split = s.split("[_-]");
        return split[0] + Arrays.stream(split).skip(1)
                .map(p -> {
                    if (p.length() == 0) return "";
                    String firstLetter = p.substring(0, 1);
                    return (firstLetter).toUpperCase() + p.substring(1);
                })
                .collect(Collectors.joining());
    }
}