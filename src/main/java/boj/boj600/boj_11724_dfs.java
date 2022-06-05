package boj.boj600;

import java.util.ArrayList;
import java.util.Scanner;

public class boj_11724_dfs {
    static int count = 0;

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

        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                count++;
            }
            dfs(matrix, visited, 0, i);
        }

        System.out.println(count);

    }

    private static void dfs(ArrayList<Integer>[] matrix, boolean[] visited, int depth, int node) {

        visited[node] = true;
        for (int i = 0; i < matrix[node].size(); i++) {
            Integer v = matrix[node].get(i);
            if (!visited[v]) {
                visited[v] = true;
                dfs(matrix, visited, depth + 1, v);
            }
        }
    }
}
