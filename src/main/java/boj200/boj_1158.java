package boj200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_1158 {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int K = scanner.nextInt();

        Queue<Integer> queue = new LinkedList<Integer>();

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K - 1; j++) {
                queue.add(queue.poll());
            }
            list.add(queue.poll());
        }

        System.out.print("<");
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                System.out.print(list.get(i));
                break;
            }
            System.out.print(list.get(i) + ", ");
        }
        System.out.println(">");


    }

}
