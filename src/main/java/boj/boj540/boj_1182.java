package boj.boj540;

import java.util.Scanner;

public class boj_1182 {
    static int result = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int s = scanner.nextInt();

        int[] array = new int[n];
        int[] output = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        boolean[] visited = new boolean[n];

        dfs(array, output, visited, 0, 0, 0, s, n);

        System.out.println(result);
    }

    private static void dfs(int[] array, int[] output, boolean[] visited, int start, int depth, int sum, int s, int n) {

        for (int i = 0; i < depth; i++) {
            System.out.print(output[i] + " ");
        }
        System.out.println();

        if (depth > 0 && sum == s) {
            result++;
        }

        for (int i = start; i < n; i++) {
            output[depth] = array[i];
            dfs(array, output, visited, i + 1, depth + 1, sum + array[i], s, n);
        }
    }
}
