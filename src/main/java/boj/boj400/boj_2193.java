package boj.boj400;

import java.util.Scanner;

public class boj_2193 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        long[][] dp = new long[n + 1][2];

        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
            dp[i][1] = dp[i - 1][0];
        }

        long a = 0;

        for (int i = 0; i < 2; i++) {
            a += dp[n][i];
        }

        System.out.println(a);

    }

}
