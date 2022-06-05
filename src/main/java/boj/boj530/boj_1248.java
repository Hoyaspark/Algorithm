package boj.boj530;

import java.util.Scanner;

public class boj_1248 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        scanner.nextLine();

        char[] array = scanner.nextLine().toCharArray();

        int[] list = new int[]{-10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        char[][] matrix = new char[n][n];
        int[] output = new int[n];

        for (int i = 0,k=0; i < n; i++) {
            for (int j = i; j < n; j++,k++) {
                matrix[i][j] = array[k];
            }
        }

        dfs(list, matrix, output, 0, list.length, n);
    }

    private static void dfs(int[] list, char[][] matrix, int[] output, int depth, int n, int r) {
        if (depth > 0) {
            if (check(output, matrix, depth)) {
                if (depth == r) {
                    for (int i = 0; i < depth; i++) {
                        System.out.print(output[i] + " ");
                    }
                    System.out.println();
                    System.exit(0);
                }

            } else {
                return;
            }
        }

        for (int i = 0; i < n; i++) {
            output[depth] = list[i];
            dfs(list, matrix, output, depth + 1, n, r);
        }
    }

    private static boolean check(int[] output, char[][] matrix, int depth) {

        for (int i = 0; i < depth; i++) {
            int sum = 0;
            for (int j = i; j < depth; j++) {
                sum += output[j];
                if (matrix[i][j] == '+') {
                    if (sum < 1) {
                        return false;
                    }
                } else if (matrix[i][j] == '-') {
                    if (sum > -1) {
                        return false;
                    }
                } else if (matrix[i][j] == '0') {
                    if (sum != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
