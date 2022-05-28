package boj600;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_1260 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int v = scanner.nextInt();

        ArrayList<Integer>[] matrix = new ArrayList[n + 1];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            matrix[a].add(b);
            matrix[b].add(a);
        }

        for (int i = 0; i < matrix.length; i++) {
            matrix[i].sort((a, b) -> a - b);
        }

        boolean[] visited = new boolean[n + 1];
        visited[v] = true;
        dfs(matrix, visited, 0, v);

        System.out.println();
        visited = new boolean[n + 1];
        bfs(matrix, visited, v);
    }

    private static void bfs(ArrayList<Integer>[] matrix, boolean[] visited, int node) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            System.out.print(poll + " ");

            for (int i = 0; i < matrix[poll].size(); i++) {
                Integer v = matrix[poll].get(i);
                if (!visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }

    }

    private static void dfs(ArrayList<Integer>[] matrix, boolean[] visited, int depth, int node) {
        System.out.print(node + " ");

        for (int i = 0; i < matrix[node].size(); i++) {
            Integer v = matrix[node].get(i);
            if (!visited[v]) {
                visited[v] = true;
                dfs(matrix, visited, depth + 1, v);
            }
        }
    }
}
