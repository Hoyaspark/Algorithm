package review;

import java.util.Scanner;

public class review_permutation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int r = scanner.nextInt();

        int[] arr = new int[n + 1];
        int[] output = new int[n];
        boolean[] visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = scanner.nextInt();
        }

        permutation(arr, output, visited, 0, n, r);
    }

    private static void permutation(int[] arr, int[] output, boolean[] visited, int depth, int n,
        int r) {
        if (depth == r) {
            for (int i = 0; i < r; i++) {
                System.out.print(output[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                permutation(arr, output, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }

}
