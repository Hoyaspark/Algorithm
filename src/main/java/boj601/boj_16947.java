package boj601;

import java.util.*;

public class boj_16947 {
    static boolean check = false;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        ArrayList<Integer>[] matrix = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; i++) {
            matrix[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            matrix[a].add(b);
            matrix[b].add(a);
        }

        for (int i = 1; i < n + 1; i++) {
            matrix[i].sort((a, b) -> a - b);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            if (check) {
                break;
            }
            boolean[] visited = new boolean[n + 1];
            list = new ArrayList<Integer>();
            visited[i] = true;
            list.add(i);
            dfs(matrix, visited, i, -1, i, list);

        }

        int[] result = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(result, -1);
        for (int i = 0; i < list.size(); i++) {
            result[list.get(i)] = 0;
        }

        //bfs 시작?
        bfs(matrix, visited, result, list.get(0));

        for (int i = 1; i < n + 1; i++) {
            System.out.print(result[i] + " ");
        }

        System.out.println();

    }

    private static void bfs(ArrayList<Integer>[] matrix, boolean[] visited, int[] result, int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            for (int i = 0; i < matrix[poll].size(); i++) {
                Integer node = matrix[poll].get(i);

                if (!visited[node]) {
                    visited[node] = true;
                    if (result[node] != 0) {
                        result[node] = result[poll] + 1;
                    }
                    queue.add(node);
                }
            }
        }
    }

    private static void dfs(ArrayList<Integer>[] matrix, boolean[] visited, int start, int prev, int node, ArrayList<Integer> list) {
        if (check) {
            return;
        }

        for (int i = 0; i < matrix[node].size(); i++) {
            Integer v = matrix[node].get(i);

            if (check) {
                return;
            }
            if (!visited[v]) {
                visited[v] = true;
                list.add(v);
                dfs(matrix, visited, start, node, v, list);
            } else if (v != prev && v == start) {
                check = true;
                return;
            }
        }
    }
}
