package boj.boj301;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_17103 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i = 0; i < n; i++) {
            queue.add(scanner.nextInt());
        }

        boolean[] check = new boolean[1_000_001];

        Arrays.fill(check, true);
        ArrayList<Integer> list = new ArrayList<>();
        check[1] = false;

        for (int i = 2; i <= 1_000_000; i++) {
            if (check[i]) {
                list.add(i);
                for (int j = 2; i * j <= 1_000_000; j++) {
                    check[i * j] = false;
                }
            }
        }

        while (!queue.isEmpty()) {
            Integer num = queue.poll();

            int count = 0;
            for (int i = 0; i < list.size(); i++) {
                if (num - list.get(i) >= num / 2) {
                    if (check[num - list.get(i)]) {
                        count++;
                    }
                } else {
                    break;
                }
            }

            System.out.println(count);
        }

    }

}
