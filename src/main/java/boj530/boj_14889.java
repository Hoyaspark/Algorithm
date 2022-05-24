package boj530;

import java.util.ArrayList;
import java.util.Scanner;

public class boj_14889 {
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        boolean[] visited = new boolean[n];

        dfs(matrix, visited, 0, n, n / 2);

        System.out.println(min);
    }

    private static void dfs(int[][] matrix, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            ArrayList<Integer> startTeam = new ArrayList<>();
            ArrayList<Integer> linkTeam = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    startTeam.add(i);
                } else {
                    linkTeam.add(i);
                }
            }

            int sumA = 0, sumB = 0;
            for (int i = 0; i < startTeam.size(); i++) {
                Integer a = startTeam.get(i);
                Integer c = linkTeam.get(i);
                for (int j = i + 1; j < startTeam.size(); j++) {
                    Integer b = startTeam.get(j);
                    Integer d = linkTeam.get(j);
                    sumA += matrix[a][b] + matrix[b][a];
                    sumB += matrix[c][d] + matrix[d][c];
                }
            }

            min = Math.min(min, Math.abs(sumA - sumB));

            return;
        }

        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(matrix, visited, i + 1, n, r - 1);
                visited[i] = false;
            }
        }
    }

    private static void cal() {

    }
}
