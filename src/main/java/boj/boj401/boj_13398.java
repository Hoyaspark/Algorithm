package boj.boj401;

import java.util.Arrays;
import java.util.Scanner;

public class boj_13398 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] arr = new int[n + 1];
        int[][] dp = new int[n + 1][3];

        for (int i = 1; i <= n; i++) {
            arr[i] = scanner.nextInt();
        }

        dp[1][0] = arr[1];
        dp[1][1] = arr[1];

        for (int i = 2; i <= n; i++) {
            // 지금까지 제거 안한 경우
            dp[i][0] = Math.max(dp[i - 1][0] + arr[i], arr[i]);
            // 지금까지 제거 했던 경우 or 지금거 제거 하는 경우
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + arr[i]);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }


        System.out.println(max);

    }
}
