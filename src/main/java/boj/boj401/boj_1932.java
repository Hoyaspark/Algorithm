package boj.boj401;

import java.util.Scanner;

public class boj_1932 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        scanner.nextLine();

        long[][] matrix = new long[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            String[] s = scanner.nextLine().split(" ");

            for (int j = 1; j <= s.length; j++) {
                matrix[i][j] = Integer.valueOf(s[j - 1]);
            }

            for (int j = s.length + 1; j <= n; j++) {
                matrix[i][j] = 0;
            }
        }

        long[][] dp = new long[n + 1][n + 1];

        if (n == 1) {
            System.out.println(matrix[1][1]);
            return;
        } else if (n == 2) {
            System.out.println(Math.max(matrix[1][1] + matrix[2][1], matrix[1][1] + matrix[2][2]));
            return;
        }

        dp[1][1] = matrix[1][1];
        dp[2][1] = matrix[1][1] + matrix[2][1];
        dp[2][2] = matrix[1][1] + matrix[2][2];


        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == 1) {
                    dp[i][j] = dp[i - 1][j] + matrix[i][j];
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + matrix[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + matrix[i][j];
                }
            }
        }

        long max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dp[n][i]);
        }

        System.out.println(max);

    }

}
