package boj510;

import java.util.Scanner;

public class boj_15649 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int r = scanner.nextInt();

        int[] arr = new int[n];
        int[] output = new int[n];
        boolean[] visited = new boolean[n];

        for (int i = 1; i <= n; i++) {
            arr[i-1] = i;
        }

        dfs(arr, visited, output,0, n, r);

    }

    private static void dfs(int[] arr, boolean[] visited, int[] output, int depth, int n, int r) {

        if (depth == r) {
            for (int i = 0; i < depth; i++) {
                System.out.print(output[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                dfs(arr, visited, output,depth + 1, n, r);
                visited[i] = false;
            }
        }
    }
}
