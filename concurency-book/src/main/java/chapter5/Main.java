package chapter5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int box = scanner.nextInt();
        int[] day = new int[box];
        int[] pills = new int[box];
        int[] start = new int[box];
        int[] finish = new int[box];
        int[] maxPillsWindow = new int[box];
        int[] maxPills = new int[box];
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        int sum = 0;
        int result = 0;

        ArrayList<Box> boxs = new ArrayList<>();

        for (int i = 0; i < box; i++) {
            boxs.add(new Box(scanner.nextInt(), scanner.nextInt()));
        }

        boxs.sort(new Comparator<Box>() {
            @Override
            public int compare(Box box1, Box box2) {
                return box1.day > box2.day ? 1 : -1;
            }
        });
        for (Box booox : boxs) {
            System.out.println(booox);
        }

        for (Box box1 : boxs) {

        }


//        for (int i = 0; i < box; i++) {
//            day[i] = scanner.nextInt();
//            pills[i] = scanner.nextInt();
//        }
        scanner.close();

//        for (int i = 0; i < box; i++) {
//            start[i] = day[i];
//            finish[i] = day[i] + pills[i] - 1;
//            maxPillsWindow[i] = finish[i] - start[i] + 1;
//            maxPills[i] = Math.min(maxPillsWindow[i], pills[i]);
//        }
//
//        for (int i = 0; i < box; i++) {
//            sum = maxPills[i];
//            list.clear();
//            list.add(i);
//            int cont = finish[i];
//            for (int j = 0; j < box; j++) {
//                if (!(start[i] >= start[j] && start[i] <= finish[j])) {
//                    if (!(finish[i] >= start[j] && finish[i] <= finish[j]) && cont != start[j]) {
//                        if (!(start[i] <= start[j] && finish[i] >= finish[j])) {
//                            sum += maxPills[j];
//                            cont = finish[j];
//                            list.add(j);
//                        }
//                    }
//                }
//            }
//            System.out.println(start[i] + " // " + finish[i] + " max pills: " + maxPills[i]);
//            if (result < sum) {
//                result = sum;
//                list1.clear();
//                list1.addAll(list);
//            }
//        }
//
//        System.out.println(result);
//        for (int i = list1.size() - 1; i >= 0; i--) {
//            System.out.print(list1.get(i) + " ");
//        }
//
//
//    }
    }
}

