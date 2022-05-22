package boj510;

import java.util.Scanner;

public class boj_15652 {
    static StringBuilder str = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int r = scanner.nextInt();

        int[] arr = new int[n];
        int[] output = new int[n];
        for (int i = 1; i <= n; i++) {
            arr[i - 1] = i;
        }

        dfs(arr, output, 0,0, n, r);

        System.out.println(str);
    }

    private static void dfs(int[] arr, int[] output, int start, int depth, int n, int r) {
        if (depth == r) {
            for (int i = 0; i < depth; i++) {
                str.append(output[i] + " ");
            }
            str.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            output[depth] = arr[i];
            dfs(arr, output, i,depth + 1, n, r);
        }
    }
}
