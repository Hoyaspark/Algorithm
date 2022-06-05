package boj.boj401;

import java.util.Arrays;
import java.util.Scanner;

public class boj_11054 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] arr = new int[n + 1];
        int[] dp1 = new int[n + 1];
        int[] dp2 = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = scanner.nextInt();
        }

        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);

        // 오름차순 가장 긴 수열
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp1[i] = Math.max(dp1[i], dp1[j] + 1);
                }
            }
        }

        // 내림차순 가장 긴 수열

        for (int i = n; i >= 1; i--) {
            for (int j = n; j > i; j--) {
                if (arr[i] > arr[j]) {
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);
                }
            }
        }

        int[] result = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            result[i] = dp1[i] + dp2[i] - 1;
        }

        int max = Arrays.stream(result).max().getAsInt();

        System.out.println(max);

    }
}
