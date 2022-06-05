package boj.boj600;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_11724_bfs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        ArrayList<Integer>[] matrix = new ArrayList[n + 1];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            matrix[a].add(b);
            matrix[b].add(a);
        }

        boolean[] visited = new boolean[n + 1];

        int result = 0;
        for (int i = 1; i < n + 1; i++) {
            if (bfs(matrix, visited, i)) {
                result++;
            }
        }

        System.out.println(result);

    }

    private static boolean bfs(ArrayList<Integer>[] matrix, boolean[] visited, int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        if (visited[node]) {
            return false;
        }
        visited[node] = true;

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (int i = 0; i < matrix[poll].size(); i++) {
                Integer v = matrix[poll].get(i);
                if (!visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
        return true;
    }
}
