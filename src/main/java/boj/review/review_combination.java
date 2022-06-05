package boj.review;

import java.util.Scanner;

public class review_combination {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int r = scanner.nextInt();

        int[] arr = new int[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        combination(arr, visited, 0, n, r);

    }

    private static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();

            return;
        }

        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(arr, visited, i + 1, n, r - 1);
                visited[i] = false;
            }

        }
    }

}
