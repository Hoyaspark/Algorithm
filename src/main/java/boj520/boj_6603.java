package boj520;

import java.util.ArrayList;
import java.util.Scanner;

public class boj_6603 {
    static StringBuilder str = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int k = scanner.nextInt();

            if (k == 0) {
                System.out.println(str);
                return;
            }

            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 0; i < k; i++) {
                list.add(scanner.nextInt());
            }

            boolean[] visited = new boolean[k];

            dfs(list, visited, 0, k, 6);

            str.append("\n");
        }
    }

    private static void dfs(ArrayList<Integer> list, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    str.append(list.get(i) + " ");
                }
            }
            str.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(list, visited, i + 1, n, r - 1);
                visited[i] = false;
            }
        }
    }
}
