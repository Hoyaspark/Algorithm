package day7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_11000 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        ArrayList<Node> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            list.add(new Node(start, end));
        }

        list.sort((a, b) -> {
            return b.getY() - a.getY();
        });

        int max = list.get(0).getY();

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        boolean[] visited = new boolean[max + 1];

        for (int i = 0; i <= max; i++) {
            matrix.add(new ArrayList<>());
        }

        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            matrix.get(node.getX()).add(node.getY());
        }

        int count = 0;

        for (int i = 1; i < visited.length; i++) {

            if (!visited[i]) {
                start(matrix, visited, i);
                count++;
            }
        }

        System.out.println(count);

    }

    private static void start(
        ArrayList<ArrayList<Integer>> matrix, boolean[] visited,
        int num) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(num);
        visited[num] = true;

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            for (int i = 0; i < matrix.get(poll).size(); i++) {
                Integer y = matrix.get(poll).get(i);
                if (visited[y] == false) {
                    queue.add(y);
                    visited[y] = true;
                }
            }
        }

    }

    static class Node {
        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

}
