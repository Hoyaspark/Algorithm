package boj.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_16928 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] source = new int[101];
        int[] dest = new int[101];
        boolean[] visited = new boolean[101];
        for (int i = 0; i < 101; i++) {
            source[i] = 0;
            dest[i] = 0;
            visited[i] = false;
        }

        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            source[a] = b;
        }

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            source[a] = b;
        }

        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(1, 0));
        visited[1] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int index = node.getIndex();
            int weight = node.getWeight();

            if (index == 100) {
                break;
            }

            for (int i = 1; i < 7; i++) {
                int y = index + i;
                if (y > 100) {
                    continue;
                }

                if (source[y] != 0) {
                    y = source[y];
                }

                if (!visited[y]) {
                    dest[y] = weight + 1;
                    visited[y] = true;
                    queue.add(new Node(y, weight + 1));
                }

            }
        }

        System.out.println(dest[100]);
    }

    static class Node {
        private int index;
        private int weight;

        public Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }

        public int getIndex() {
            return index;
        }

        public int getWeight() {
            return weight;
        }
    }

}
