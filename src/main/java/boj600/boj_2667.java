package boj600;

import java.util.*;

public class boj_2667 {
    static int[] destX = new int[]{-1, 1, 0, 0};
    static int[] destY = new int[]{0, 0, -1, 1};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[][] list = new int[n][n];

        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            char[] chars = scanner.nextLine().toCharArray();
            for (int j = 0; j < n; j++) {
                list[i][j] = chars[j] - '0';
            }
        }

        boolean[][] visited = new boolean[n][n];

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && list[i][j] != 0) {
                    bfs(list, visited, new Node(i, j), result);
                }
            }
        }

        System.out.println(result.size());
        result.sort((a, b) -> a - b);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    private static void bfs(int[][] list, boolean[][] visited, Node node, ArrayList<Integer> result) {
        Queue<Node> queue = new LinkedList<>();

        queue.add(node);
        visited[node.x][node.y] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int x = poll.x;
            int y = poll.y;
            for (int i = 0; i < 4; i++) {
                int xx = x + destX[i];
                int yy = y + destY[i];
                if (xx < 0 || yy < 0 || xx > list.length - 1 || yy > list.length - 1) {
                    continue;
                }
                if (!visited[xx][yy] && list[xx][yy] != 0) {
                    visited[xx][yy] = true;
                    queue.add(new Node(xx, yy));
                    count++;
                }
            }
        }
        result.add(count);
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
