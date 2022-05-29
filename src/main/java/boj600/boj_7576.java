package boj600;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_7576 {
    static int[] destX = new int[]{-1, 1, 0, 0};
    static int[] destY = new int[]{0, 0, 1, -1};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        int n = scanner.nextInt();

        int[][] matrix = new int[n][m];
        int[][] dest = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        ArrayList<Node> startNode = new ArrayList<>();

        boolean preCondition = false;

        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(input[j]);
                if (num == 0) {
                    preCondition = true;
                }
                if (num == 1) {
                    startNode.add(new Node(i, j));
                }

                matrix[i][j] = num;
            }
        }

        // bfs 시작 전 모든 토마토가 익어있는지 확인
        if (!preCondition) {
            System.out.println(0);
            return;
        }

        // bfs 시작
        bfs(matrix, visited, dest, startNode);

        // 모든 토마토가 익지 못하는 상황 체크
        // 0이 남아있나 확인
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        // 모두 익을 떄까지의 최소 날짜 출력
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(max, dest[i][j]);
            }
        }

        System.out.println(max);

    }

    private static void bfs(int[][] matrix, boolean[][] visited, int[][] dest, ArrayList<Node> startNode) {
        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < startNode.size(); i++) {
            Node node = startNode.get(i);
            queue.add(node);
            visited[node.x][node.y] = true;
            dest[node.x][node.y] = 0;
        }

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int x = poll.x;
            int y = poll.y;

            for (int i = 0; i < 4; i++) {
                int xx = x + destX[i];
                int yy = y + destY[i];

                if (xx < 0 || yy < 0 || xx > matrix.length - 1 || yy > matrix[0].length - 1) {
                    continue;
                }

                if (!visited[xx][yy] && matrix[xx][yy] == 0) {
                    visited[xx][yy] = true;
                    dest[xx][yy] = dest[x][y] + 1;
                    matrix[xx][yy] = 1;
                    queue.add(new Node(xx, yy));
                }
            }
        }
    }

    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
