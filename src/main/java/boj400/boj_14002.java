package boj400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class boj_14002 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        Node[] dp = new Node[n];

        for (int i = 0; i < n; i++) {
            dp[i] = new Node(1, list.get(i));
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (list.get(j) < list.get(i)) {
                    if (dp[j].size + 1 > dp[i].size) {
                        dp[i].list = new ArrayList<>();
                        dp[i].list.addAll(dp[j].list);
                        dp[i].list.add(list.get(i));
                        dp[i].size = dp[j].size + 1;
                    }
                }
            }
        }

        Arrays.sort(dp, (a, b) -> b.size - a.size);

        System.out.println(dp[0].size);
        for (int i = 0; i < dp[0].size; i++) {
            System.out.print(dp[0].list.get(i) + " ");
        }
        System.out.println();
    }

    static class Node {
        int size;
        ArrayList<Integer> list;

        public Node(int size, Integer item) {
            this.size = size;
            this.list = new ArrayList<>();
            this.list.add(item);
        }
    }

}
