package boj.boj400;

import java.util.Arrays;
import java.util.Scanner;

public class boj_16194 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = scanner.nextInt();
        }

        int[] dp = new int[n + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = p[1];

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j] + p[j]);
                /**
                 * dp[2] = dp[2-1],p[1] <> dp[2-2],p[2]
                 */
            }
        }

        System.out.println(dp[n]);
    }

}
