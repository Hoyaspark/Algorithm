package boj.boj520;

import java.util.Scanner;

public class boj_10971 {
    static long min = Long.MAX_VALUE;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        long[][] matrix = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Long.valueOf(scanner.nextInt());
            }
        }

        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            visited[i] = true;
            dfs(matrix, visited, 0, n, i, i, 0);
            visited[i] = false;
        }
        System.out.println(min);

    }

    private static void dfs(long[][] matrix, boolean[] visited, int depth, int n, int start, int node, long sum) {
        if (depth == n - 1) {
            if (matrix[node][start] != 0) {
                sum += matrix[node][start];
                min = Math.min(min, sum);
            }
            return;
        }
        // depth == -1
        // depth = 0 --> 1
        // depth = 1 --> 1, 2
        // depth = 2 --> 1, 2, 3
        // depth = 3 --> 1,2,3,4
        //

        for (int i = 0; i < n; i++) {
            if (!visited[i] && matrix[node][i] != 0) {
                visited[i] = true;
                dfs(matrix, visited, depth + 1, n, start, i, sum + matrix[node][i]);
                visited[i] = false;
            }
        }
    }

}
