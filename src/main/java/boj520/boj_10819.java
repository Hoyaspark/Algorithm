package boj520;

import java.util.ArrayList;
import java.util.Scanner;

public class boj_10819 {

    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        boolean[] visited = new boolean[n];
        int[] output = new int[n];

        dfs(list, visited, output, 0, n, n);

        System.out.println(max);
    }

    private static void dfs(ArrayList<Integer> list, boolean[] visited, int[] output, int depth, int n, int r) {
        if (depth == r) {
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum += Math.abs(output[i] - output[i + 1]);
            }
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = list.get(i);
                dfs(list, visited, output, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }
}
