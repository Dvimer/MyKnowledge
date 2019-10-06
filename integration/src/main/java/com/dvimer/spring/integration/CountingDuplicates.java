package com.dvimer.spring.integration;

import java.util.HashSet;
import java.util.Set;

public class CountingDuplicates {
    public static int duplicateCount(String text) {

        text = text.toUpperCase();
        Set<Character> characterSet = new HashSet<>();
        Set<Character> duplicateChars = new HashSet<>();
        for (int i = 0; i < text.length(); i++) {
            if (!characterSet.add(text.charAt(i))) {
                duplicateChars.add(text.charAt(i));
            }
        }
        return duplicateChars.size();
    }

    public static void main(String[] args) {
        System.out.println(duplicateCount("abcde"));
        System.out.println(duplicateCount("abcdea"));
        System.out.println(duplicateCount("indivisibility"));
        System.out.println(duplicateCount("aaaaa"));
    }
}
