package boj401;

import java.util.Scanner;

public class boj_2133 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] dp = new int[31];

        dp[2] = 3;
        dp[4] = 1 * (6 * dp[2] + dp[2]);
        dp[6] = 2 * (6 * dp[2] + dp[2]);
        dp[8] = 3 * (6 * dp[2] + dp[2]);
        dp[10] = 4 * (6 * dp[2] + dp[2]);
        dp[12] = 5 * (6 * dp[2] + dp[2]);
        dp[14] = 6 * (6 * dp[2] + dp[2]);
        dp[16] = 7 * (6 * dp[2] + dp[2]);
        dp[18] = 8 * (6 * dp[2] + dp[2]);
        dp[20] = 9 * (6 * dp[2] + dp[2]);
        dp[22] = 10 * (6 * dp[2] + dp[2]);
        dp[24] = 11 * (6 * dp[2] + dp[2]);
        dp[26] = 12 * (6 * dp[2] + dp[2]);
        dp[28] = 13 * (6 * dp[2] + dp[2]);
        dp[30] = 14 * (6 * dp[2] + dp[2]);

        System.out.println(dp[n]);

    }
}
