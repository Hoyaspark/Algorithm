package day7;

import java.util.PriorityQueue;
import java.util.Scanner;

public class boj_1715 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> a - b);
        int N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            int num = scanner.nextInt();
            queue.add(num);
        }

        int sum = 0;
        while (queue.size() > 1) {
            Integer i = queue.poll();
            Integer j = queue.poll();

            sum += i + j;

            queue.add(i + j);
        }

        System.out.println(sum);

    }


}
