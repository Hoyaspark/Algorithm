package boj600;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_2178 {
    static int[] destX = new int[]{-1, 1, 0, 0};
    static int[] destY = new int[]{0, 0, -1, 1};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] matrix = new int[n][m];
        int[][] result = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            char[] chars = scanner.nextLine().toCharArray();
            for (int j = 0; j < m; j++) {
                matrix[i][j] = chars[j] - '0';
            }
        }


        bfs(result, matrix, visited, new Node(0, 0));

        System.out.println(result[n - 1][m - 1]);

    }


    private static void bfs(int[][] result, int[][] matrix, boolean[][] visited, Node node) {
        Queue<Node> queue = new LinkedList<>();

        queue.add(node);
        visited[node.x][node.y] = true;
        result[node.x][node.y] = 1;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            int x = poll.x;
            int y = poll.y;

            for (int i = 0; i < 4; i++) {
                int xx = destX[i] + x;
                int yy = destY[i] + y;

                if (xx < 0 || yy < 0 || xx > matrix.length - 1 || yy > matrix[0].length - 1) {
                    continue;
                }

                if (!visited[xx][yy] && matrix[xx][yy] == 1) {
                    visited[xx][yy] = true;
                    result[xx][yy] = result[x][y] + 1;
                    queue.add(new Node(xx, yy));
                }
            }
        }
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
