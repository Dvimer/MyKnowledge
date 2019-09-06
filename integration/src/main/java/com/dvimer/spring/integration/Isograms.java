package com.dvimer.spring.integration;

import java.util.HashSet;
import java.util.Set;

public class Isograms {
    public static boolean isIsogram(String str) {
       return str.length() == str.toLowerCase().chars().distinct().count();
    }


    public static void main(String[] args) {
        System.out.println(isIsogram("Dermatoglyphics"));
        System.out.println(isIsogram("isogram"));
        System.out.println(isIsogram("moose"));
        System.out.println(isIsogram("isIsogram"));
        System.out.println(isIsogram("aba"));
        System.out.println(isIsogram("moOse"));
        System.out.println(isIsogram("thumbscrewjapingly"));
        System.out.println(isIsogram(""));
    }
}
