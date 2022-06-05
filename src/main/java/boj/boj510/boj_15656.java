package boj.boj510;

import java.util.ArrayList;
import java.util.Scanner;

public class boj_15656 {
    static StringBuilder str = new StringBuilder();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int r = scanner.nextInt();

        ArrayList<Integer> list = new ArrayList<>();

        int[] output = new int[n];
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        list.sort((a, b) -> a - b);

        dfs(list, output, 0, n, r);

        System.out.println(str);
    }

    private static void dfs(ArrayList<Integer> list, int[] output,int depth, int n, int r) {
        if (r == 0) {
            for (int i = 0; i < depth; i++) {
                str.append(output[i] + " ");
            }
            str.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            output[depth] = list.get(i);
            dfs(list, output, depth + 1, n, r-1);
        }
    }
}
