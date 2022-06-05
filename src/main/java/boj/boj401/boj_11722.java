package boj.boj401;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class boj_11722 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = scanner.nextInt();
        }

        Arrays.fill(dp, 1);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (arr[j] > arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
