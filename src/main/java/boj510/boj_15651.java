package boj510;

import java.io.*;
import java.util.Scanner;

public class boj_15651 {
    static StringBuilder str = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int n = Integer.valueOf(split[0]);
        int r = Integer.valueOf(split[1]);

        int[] arr = new int[n];
        int[] output = new int[n];

        for (int i = 1; i <= n; i++) {
            arr[i - 1] = i;
        }

        dfs(arr, output,0, n, r);

        System.out.println(str);

    }

    private static void dfs(int[] arr, int[] output, int depth, int n, int r) throws IOException {
        if (depth == r) {
            for (int i = 0; i < depth; i++) {
                str.append(output[i] + " ");
            }
            str.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            output[depth] = arr[i];
            dfs(arr, output, depth + 1, n, r);
        }
    }
}
