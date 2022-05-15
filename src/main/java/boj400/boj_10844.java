package boj400;

import java.util.Scanner;

public class boj_10844 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        long[][] dp = new long[101][10];

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    dp[i][j] = (dp[i - 1][1]) % 1000000000;
                } else if (j == 9) {
                    dp[i][j] = (dp[i - 1][8]) % 1000000000;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
                }
            }
        }

        long a = 0;

        for (int i = 0; i < 10; i++) {
            a += dp[n][i];
        }

        System.out.println(a % 1000000000);

    }

}
