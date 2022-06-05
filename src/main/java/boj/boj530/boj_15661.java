package boj.boj530;

import java.util.ArrayList;
import java.util.Scanner;

public class boj_15661 {

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[][] array = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = scanner.nextInt();
            }
        }

        // 조합 사용
        // nCn-1까지 해서 능력치 차이의 최솟값 확인
        for (int i = 1; i < (n / 2) + 1; i++) {
            boolean[] visited = new boolean[n];
            dfs(array, visited, 0, n, i);
        }

        System.out.println(min);

    }

    private static void dfs(int[][] array, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            ArrayList<Integer> startTeam = new ArrayList<>();
            ArrayList<Integer> linkTeam = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    startTeam.add(i);
                }else {
                    linkTeam.add(i);
                }
            }

            int sumA = 0, sumB = 0;
            for (int i = 0; i < startTeam.size(); i++) {
                for (int j = i + 1; j < startTeam.size(); j++) {
                    Integer a = startTeam.get(i);
                    Integer b = startTeam.get(j);

                    sumA += array[a][b] + array[b][a];
                }
            }

            for (int i = 0; i < linkTeam.size(); i++) {
                for (int j = i + 1; j < linkTeam.size(); j++) {
                    Integer a = linkTeam.get(i);
                    Integer b = linkTeam.get(j);
                    sumB += array[a][b] + array[b][a];
                }
            }

            min = Math.min(min, Math.abs(sumA - sumB));

            return;
        }

        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(array, visited, i + 1, n, r - 1);
                visited[i] = false;
            }
        }
    }
}
