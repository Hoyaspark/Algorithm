package boj.boj530;

import java.util.*;

public class boj_2529 {
    static char[] stack;
    static List<String> result = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        scanner.nextLine();

        List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        String[] s = scanner.nextLine().split(" ");

        stack = new char[n];
        for (int i = 0; i < s.length; i++) {
            stack[i] = s[i].charAt(0);
        }

        // 10Cn+1
        boolean[] visited = new boolean[10];
        int[] output = new int[n + 1];

        dfs(list, output, visited, 0, 10, n + 1);

        System.out.println(result.get(result.size()-1));
        System.out.println(result.get(0));

    }

    private static void dfs(List<Integer> list,int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            for (int i = 0; i < r - 1; i++) {
                if (stack[i] == '>') {
                    if (output[i] < output[i + 1]) {
                        return;
                    }
                } else if (stack[i] == '<') {
                    if (output[i] > output[i + 1]) {
                        return;
                    }
                }
            }
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < r; i++) {
                str.append(output[i]);
            }
            result.add(str.toString());
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = list.get(i);
                dfs(list, output, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }
}
