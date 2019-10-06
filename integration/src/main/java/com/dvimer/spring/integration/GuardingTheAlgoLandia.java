package com.dvimer.spring.integration;

public class GuardingTheAlgoLandia {
    public static void main(String[] args) {
        System.out.println(findNeededGuards(new boolean[]{true, true, false, true, false}));
        System.out.println(findNeededGuards(new boolean[]{false, false, true, false, false}));
        System.out.println(findNeededGuards(new boolean[]{false, false, false, false, false}));
    }

    public static int findNeededGuards(boolean[] k) {
        int needGuard = 0;
        boolean isNeed = false;
        for (int i = 0; i < k.length; i++) {
            if (k[i] == false && !isNeed) {
                isNeed = true;
            } else if (k[i] == false && isNeed) {
                needGuard++;
                isNeed = false;
            } else {
                isNeed = false;
            }
        }
        return needGuard;
    }
}
