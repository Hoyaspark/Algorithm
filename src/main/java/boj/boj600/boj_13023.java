package boj.boj600;

import java.util.ArrayList;
import java.util.Scanner;

public class boj_13023 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        ArrayList<Integer>[] matrix = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            matrix[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            matrix[a].add(b);
            matrix[b].add(a);
        }

        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            visited[i] = true;
            dfs(matrix, visited, i,0, n, 4);
        }

        System.out.println(0);
    }

    private static void dfs(ArrayList<Integer>[] matrix, boolean[] visited, int node, int depth, int n, int r) {
        if (depth == r) {
            System.out.println(1);
            System.exit(0);
        }

        for (int i = 0; i < matrix[node].size(); i++) {
            if (!visited[matrix[node].get(i)]) {
                visited[matrix[node].get(i)] = true;
                dfs(matrix, visited, matrix[node].get(i), depth + 1, n, r);
                visited[matrix[node].get(i)] = false;
            }
        }
    }
}
