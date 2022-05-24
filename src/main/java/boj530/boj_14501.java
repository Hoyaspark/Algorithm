package boj530;

import java.util.ArrayList;
import java.util.Scanner;

public class boj_14501 {
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Node(scanner.nextInt(), scanner.nextInt()));
        }

        boolean[] visited = new boolean[n];

        dfs(list, visited, n, 0, 0,0);

        System.out.println(max);
    }

    private static void dfs(ArrayList<Node> list, boolean[] visited, int n, int start, int sum,int prevSum) {
        if (n == start) {
            max = Math.max(max, sum);
            return;
        } else if (start > n) {
            max = Math.max(max, prevSum);
            return;
        }

        for (int i = start; i < n; i++) {
            Node node = list.get(i);
            if (!visited[i]) {
                visited[i] = true;
                dfs(list, visited, n, i + node.t, sum + node.p, sum);
                visited[i] = false;
            }
        }
    }

    static class Node {
        int t;
        int p;

        public Node(int t, int p) {
            this.t = t;
            this.p = p;
        }
    }
}
