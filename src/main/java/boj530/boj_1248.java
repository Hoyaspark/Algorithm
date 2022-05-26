package boj530;

import java.util.*;

public class boj_1248 {
    static ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        scanner.nextLine();
        char[] array = scanner.nextLine().toCharArray();

        char[][] matrix = new char[n][n];

        for (int i = 0, k = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++, k++) {
                matrix[i][i+j] = array[k];
            }
        }
        int[] list = new int[]{
                -10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 0,
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        boolean[] visited = new boolean[21];
        int[] output = new int[21];
        dfs(list, matrix, output, visited, 0, list.length, n, n, 0);

        System.out.println(temp.get(0));

    }

    private static void dfs(int[] list, char[][] matrix, int[] output, boolean[] visited, int depth, int n, int r,int size, int row) {
        if (depth == r) {
            int sum = 0;
            for (int i = 0; i < r; i++) {
                sum += output[i];
            }
            for (int i = size - 1, k = 0,s=r-1; i > row - 1; i--, k++,s--) {
                char op = matrix[row][i];

                if (sum > 0) {
                    if (op != '+') {
                        return;
                    }
                } else if (sum < 0) {
                    if (op != '-') {
                        return;
                    }
                } else {
                    if (op != '0') {
                        return;
                    }
                }
                sum -= output[s];
            }
            // 테스트 통과
            ArrayList<Integer> t = new ArrayList<>();
            for (int i = 0; i < r; i++) {
                t.add(output[i]);
            }
            temp.add(t);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = list[i];
                dfs(list, matrix, output, visited, depth + 1, n, r,size, row);
                visited[i] = false;
            }
        }
    }
}
