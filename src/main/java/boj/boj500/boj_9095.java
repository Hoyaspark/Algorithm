package boj.boj500;

import java.util.ArrayList;
import java.util.Scanner;

public class boj_9095 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        int[] dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            list.add(scanner.nextInt());
        }

        for (int i = 4; i < 12; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(dp[list.get(i)]);
        }
    }
}
