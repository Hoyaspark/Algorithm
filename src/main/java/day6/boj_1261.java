package day6;

import java.util.PriorityQueue;
import java.util.Scanner;

public class boj_1261 {

    static int[][] matrix;
    static int[][] node;
    static final int INF = 999_999_999;
    static int[] sourceX = new int[]{1, 0, -1, 0};
    static int[] sourceY = new int[]{0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt(); // 4
        int N = scanner.nextInt(); // 2

        scanner.nextLine(); // 버퍼 제거

        matrix = new int[N + 1][M + 1];
        node = new int[N + 1][M + 1];

        for (int i = 0; i < N; i++) {
            String[] split = scanner.nextLine().split("");
            for (int j = 0; j < M; j++) {
                matrix[i + 1][j + 1] = Integer.parseInt(split[j]);
                node[i + 1][j + 1] = INF;
            }
        }

        start(N, M);

        System.out.println(node[N][M]);

    }

    public static void start(int N, int M) {
        PriorityQueue<Location> queue = new PriorityQueue<>(
            (a, b) -> a.getWeight() - b.getWeight());

        queue.add(new Location(1, 1,0));
        node[1][1] = 0;

        while (!queue.isEmpty()) {
            Location location = queue.poll();
            int x = location.getX();
            int y = location.getY();
            int weight = location.getWeight();

            if (weight > node[x][y]) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int xx = sourceX[i] + x;
                int yy = sourceY[i] + y;

                if (xx < 1 || yy < 1 || xx > N || yy > M) {
                    continue;
                }

                if (node[xx][yy] > node[x][y] + matrix[xx][yy]) {
                    node[xx][yy] = node[x][y] + matrix[xx][yy];
                    queue.add(new Location(xx, yy, node[xx][yy]));
                }
            }
        }

    }

    static class Location {
        private int x;
        private int y;
        private int weight;

        public Location(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getWeight() {
            return weight;
        }
    }

}
