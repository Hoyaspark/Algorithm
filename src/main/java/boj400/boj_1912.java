package boj400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class boj_1912 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        int[] dp = new int[n];
        dp[0] = list.get(0);

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + list.get(i), list.get(i));
        }

        Arrays.sort(dp);

        System.out.println(dp[n - 1]);
    }

}
