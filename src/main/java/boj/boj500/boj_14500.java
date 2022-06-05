package boj.boj500;

import java.util.Scanner;

public class boj_14500 {
    static int result = 0,n,m;
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        int[][] arr = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, arr[i][j], arr, visited, 1);
                visited[i][j] = false;
                // i,j 일때 ㅜ 모양 검사
            }
        }

        System.out.println(result);

    }


    static void dfs(int i, int j, int sum, int[][] arr, boolean[][] visited, int depth) {

        if (depth == 4) {
            result = Math.max(result, sum);
            return;
        }

        for (int k = 0; k < 4; k++) {
            int xx = i + dx[k];
            int yy = j + dy[k];

            if (xx < 0 || yy < 0 || yy > m - 1 || xx > n - 1) {
                continue;
            }

            if (!visited[xx][yy]) {
                if (depth == 2) {
                    visited[xx][yy] = true;
                    dfs(i, j, sum + arr[xx][yy], arr, visited, depth + 1);
                    visited[xx][yy] = false;
                }
                visited[xx][yy] = true;
                dfs(xx, yy, sum + arr[xx][yy], arr, visited, depth + 1);
                visited[xx][yy] = false;
            }
        }
    }
}
