package boj401;

import java.util.ArrayList;
import java.util.Scanner;

public class boj_9465 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Long> result = new ArrayList<>();

        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();

            long[][] array = new long[3][n + 1];

            for (int j = 1; j < 3; j++) {
                for (int k = 1; k < n + 1; k++) {
                    array[j][k] = scanner.nextInt();
                }
            }

            long[][] dp = new long[n + 1][4];

            dp[1][1] = array[1][1]; // o x
            dp[1][2] = array[2][1]; // x o
            dp[1][3] = 0; // x x

            for (int j = 2; j <= n; j++) {
                dp[j][1] = Math.max(dp[j - 1][2],dp[j - 1][3]) + array[1][j];
                dp[j][2] = Math.max(dp[j - 1][1],dp[j - 1][3]) + array[2][j];
                long temp = Math.max(dp[j - 1][1], dp[j - 1][2]);
                dp[j][3] = Math.max(temp, dp[j - 1][3]);
            }

            long max = 0;
            for (int j = 1; j <= 3; j++) {
                max = Math.max(max, dp[n][j]);
            }

            result.add(max);

        }

        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < t; i++) {
            stringBuilder.append(result.get(i) + "\n");
        }

        System.out.println(stringBuilder);
    }
}
