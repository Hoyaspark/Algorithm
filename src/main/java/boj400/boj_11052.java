package boj400;

import java.util.Scanner;

public class boj_11052 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] p = new int[n + 1];
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = scanner.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + p[j]);
            }
        }


        System.out.println(dp[n]);

        /**
         * dp[1] = dp[1-1] + p[1]
         *
         * dp[2] = dp[2-1] + p[1]
         * dp[2] = dp[2-0] + p[2]
         *
         * dp[3] = dp[3-1] + p[1]
         * dp[3] = dp[3-2] + p[2]
         * dp[3] = dp[3-3] + p[3]
         *
         * dp[4] = dp[4-1] + p[1];
         * dp[4] = dp[4-2] + p[2];
         * dp[4] = dp[4-3] + p[3];
         * dp[4] = dp[4-4] + p[4];
         */

    }

}
