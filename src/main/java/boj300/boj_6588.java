package boj300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_6588 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Queue<Integer> queue = new LinkedList<>();

        ArrayList<Integer> list = new ArrayList<>();
        boolean[] dest = new boolean[1_000_001];

        Arrays.fill(dest, true);

        while (true) {
            int num = scanner.nextInt();

            if (num == 0) {
                break;
            }
            queue.add(num);
        }

        for (int i = 2; i <= 1_000_000; i++) {
            if (dest[i]) {
                list.add(i);
            }
            for (int j = 2; i * j <= 1_000_000; j++) {
                if (!dest[i * j]) {
                    continue;
                }
                dest[i * j] = false;
            }
        }


        int i=0;
        while (!queue.isEmpty()) {
            Integer num = queue.poll();

            while(true) {
                int b = num - list.get(i++);

                if (dest[b]) {
                    System.out.println(num + " = " + list.get(i - 1) + " + " + b);
                    i = 0;
                    break;
                }
            }
        }


    }

}
