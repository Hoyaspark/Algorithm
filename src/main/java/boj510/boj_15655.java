package boj510;

import java.util.ArrayList;
import java.util.Scanner;

public class boj_15655 {
    static StringBuilder str = new StringBuilder();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int r = scanner.nextInt();

        boolean[] visited = new boolean[n];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        list.sort((a, b) -> a - b);

        dfs(list, visited, 0, n, r);

        System.out.println(str);
    }

    private static void dfs(ArrayList<Integer> list,boolean[] visited, int start, int n, int r) {
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
