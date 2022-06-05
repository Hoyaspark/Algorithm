package boj.day7;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class boj_2437 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(scanner.nextInt());
        }


        list.sort((a, b) -> a - b);

        int max = 1;

        for (int i = 0; i < list.size(); i++) {
            if (max < list.get(i)) {
                break;
            }
            max += list.get(i);
        }

        System.out.println(max);

    }


}
