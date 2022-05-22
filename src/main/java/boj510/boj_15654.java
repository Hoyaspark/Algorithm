package boj510;

import java.util.ArrayList;
import java.util.Scanner;

public class boj_15654 {
    static StringBuilder str = new StringBuilder();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int r = scanner.nextInt();

        boolean[] visited = new boolean[n];
        int[] output = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        list.sort((a, b) -> a - b);

        dfs(list, visited,output, 0,n, r);

        System.out.println(str);
    }

    private static void dfs(ArrayList<Integer> list, boolean[] visited, int[] output, int depth, int n, int r) {

        if (depth == r) {
            for (int i = 0; i < depth; i++) {
                str.append(output[i] + " ");
            }
            str.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = list.get(i);
                dfs(list, visited, output, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }
}
