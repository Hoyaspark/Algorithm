package boj600;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_7562 {

    static int[] destX = new int[]{2, 1, -1, -2, -2, -1, 1, 2};
    static int[] destY = new int[]{1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            int x = scanner.nextInt();
            int y = scanner.nextInt();

            int[][] matrix = new int[n][n];
            boolean[][] visited = new boolean[n][n];
            int[][] dest = new int[n][n];

            System.out.println(bfs(matrix, visited, dest, new Node(a, b), new Node(x, y)));

        }
    }

    private static int bfs(int[][] matrix, boolean[][] visited, int[][] dest, Node node, Node destNode) {
        Queue<Node> queue = new LinkedList<>();

        queue.add(node);
        visited[node.x][node.y] = true;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int x = poll.x;
            int y = poll.y;

            if (x == destNode.x && y == destNode.y) {
                return dest[x][y];
            }

            for (int i = 0; i < destX.length; i++) {
                int xx = x + destX[i];
                int yy = y + destY[i];

                if (xx < 0 || yy < 0 || xx > matrix.length - 1 || yy > matrix.length - 1) {
                    continue;
                }

                if (!visited[xx][yy]) {
                    visited[xx][yy] = true;
                    dest[xx][yy] = dest[x][y] + 1;
                    queue.add(new Node(xx, yy));
                }
            }
        }

        return -1;
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
