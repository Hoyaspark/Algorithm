package boj600;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_4963 {
    static int[] destX = new int[]{1, 1, 1, 0, -1, -1, -1, 0};
    static int[] destY = new int[]{-1, 0, 1, 1, 1, 0, -1, -1};
    static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> result = new ArrayList<>();

        while (true){
            count = 0;
            int m = scanner.nextInt();
            int n = scanner.nextInt();

            if (m == 0 && n == 0) {
                break;
            }

            int[][] matrix = new int[n][m];
            boolean[][] visited = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int num = scanner.nextInt();
                    matrix[i][j] = num;
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visited[i][j] && matrix[i][j] != 0) {
                        bfs(matrix, visited, new Node(i, j));
                    }
                }
            }

            result.add(count);
        }

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    private static void bfs(int[][] matrix, boolean[][] visited, Node node) {
        Queue<Node> queue = new LinkedList<>();

        queue.add(node);
        visited[node.x][node.y] = true;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int x = poll.x;
            int y = poll.y;

            for (int i = 0; i < 8; i++) {
                int xx = x + destX[i];
                int yy = y + destY[i];

                if (xx < 0 || yy < 0 || xx > matrix.length - 1 || yy > matrix[0].length - 1) {
                    continue;
                }

                if (!visited[xx][yy] && matrix[xx][yy] == 1) {
                    visited[xx][yy] = true;
                    queue.add(new Node(xx, yy));
                }
            }
        }

        count++;

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
