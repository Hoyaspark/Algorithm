package boj.boj400;

import java.util.Scanner;

public class boj_11726 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        long[] dp = new long[n + 1];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) ;
        }

        System.out.println(dp[n] % 10_007);

    }

}
