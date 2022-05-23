package boj520;

import java.util.Scanner;

public class boj_10974 {
    static StringBuilder str = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        boolean[] visited = new boolean[n];
        int[] output = new int[n];

        dfs(arr, visited, output, 0, n, n);

        System.out.println(str);
    }

    private static void dfs(int[] arr, boolean[] visited, int[] output, int depth, int n, int r) {
        if (depth == r) {
            for (int i = 0; i < depth; i++) {
                str.append(output[i] + " ");
            }
            str.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                dfs(arr, visited, output, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }
}
