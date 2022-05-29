package boj601;

import java.util.Scanner;

public class boj_16929 {
    static int[] destX = new int[]{-1, 1, 0, 0};
    static int[] destY = new int[]{0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        char[][] matrix = new char[n][m];


        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            char[] chars = scanner.nextLine().toCharArray();
            for (int j = 0; j < m; j++) {
                matrix[i][j] = chars[j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boolean[][] visited = new boolean[n][m];
                visited[i][j] = true;
                dfs(matrix, visited, 0, new Node(i, j), new Node(i, j));
            }
        }

        System.out.println("No");
    }

    private static boolean dfs(char[][] matrix, boolean[][] visited,int depth, Node start, Node prev) {

        for (int i = 0; i < 4; i++) {
            int xx = prev.x + destX[i];
            int yy = prev.y + destY[i];

            if (xx < 0 || yy < 0 || xx > matrix.length - 1 || yy > matrix[0].length - 1) {
                continue;
            }
            if (depth > 2) {
                if (xx == start.x && yy == start.y) {
                    System.out.println("Yes");
                    System.exit(0);
                }
            }

            if (!visited[xx][yy] && matrix[xx][yy] == matrix[start.x][start.y]) {
                visited[xx][yy] = true;
                dfs(matrix, visited, depth + 1, start, new Node(xx, yy));
            }
        }

        return false;
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
