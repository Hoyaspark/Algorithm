package boj401;

import java.util.ArrayList;
import java.util.Scanner;

public class boj_15988 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        long[] dp = new long[1_000_001];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < 1_000_001; i++) {
            for (int j = 1; j < 4; j++) {
                dp[i] += dp[i - j] % 1_000_000_009;
            }
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(dp[list.get(i)] % 1_000_000_009);
        }
    }

}
