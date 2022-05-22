package boj500;

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
                int sum = checkShape(arr, i, j);
                result = Math.max(result, sum);
            }
        }

        System.out.println(result);

    }

    private static int checkShape(int[][] arr, int i, int j) {
        int sum = 0;
        if (i < n -1 && i + 1 < n - 1 && i + 2 < n - 1 && j < m - 1 && j + 1 < m - 1){
            sum = Math.max(sum, arr[i][j] + arr[i + 1][j] + arr[i + 2][j] + arr[i + 1][j + 1]);
        }

        if (i < n -1 && i + 1< n- 1 && j < m-1 && j + 1< m-1 && j +2 < m-1){
            sum = Math.max(sum, arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1]);

        }

        if (i < n - 1 && i + 1 < n - 1 && i + 2 < n - 1 && j < m - 1 && j + 1 < m - 1) {
            sum = Math.max(sum, arr[i + 1][j] + arr[i][j + 1] + arr[i + 1][j + 1] + arr[i + 2][j + 1]);
        }

        if (i < n - 1 && i + 1 < n - 1 && j < m - 1 && j + 1 < m - 1 && j + 2 < m - 1) {
            sum = Math.max(sum, arr[i][j + 1] + arr[i + 1][j] + arr[i + 1][j + 1] + arr[i + 1][j + 2]);
        }
        return sum;
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
                visited[xx][yy] = true;
                dfs(xx, yy, sum + arr[xx][yy], arr, visited, depth + 1);
                visited[xx][yy] = false;
            }
        }
    }
}
