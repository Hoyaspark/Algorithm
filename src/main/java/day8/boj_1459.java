package day8;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class boj_1459 {

    static int[] aX = {-1, 0, 1, 0};
    static int[] aY = {0, 1, 0, -1};
    static int[] bX = {-1, 1, 1, -1};
    static int[] bY = {1, 1, -1, -1};

    static final long INF = 1_000_000_000 + 10_000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int X = scanner.nextInt(); // int [X][]
        int Y = scanner.nextInt(); // int [][Y]
        int W = scanner.nextInt(); // 한 블럭 가는데 걸리는 시간
        int S = scanner.nextInt(); // 대각선으로 가는데 걸리는 시간

        long[][] dest = new long[X][Y];

        for (int i = 0; i < dest.length; i++) {
            for (int j = 0; j < dest[i].length; j++) {
                dest[i][j] = INF;
            }
        }

        PriorityQueue<Node> queue = new PriorityQueue<>(
            (a, b) -> Long.compare(a.getWeight(), b.getWeight()));

        dest[0][0] = 0;
        queue.add(new Node(0, 0, 0));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int x = poll.getX();
            int y = poll.getY();

            for (int i = 0; i < 4; i++) {
                int xx = x + aX[i];
                int yy = y + aY[i];

                if (xx < 0 || yy < 0 || xx >= X || yy >= Y) {
                    continue;
                }

                if (dest[xx][yy] > dest[x][y] + W) {
                    dest[xx][yy] = dest[x][y] + W;
                    queue.add(new Node(xx, yy, dest[xx][yy]));
                }

            }

            for (int i = 0; i < 4; i++) {
                int xx = x + bX[i];
                int yy = y + bY[i];

                if (xx < 0 || yy < 0 || xx >= X || yy >= Y) {
                    continue;
                }

                if (dest[xx][yy] > dest[x][y] + S) {
                    dest[xx][yy] = dest[x][y] + S;
                    queue.add(new Node(xx, yy, dest[xx][yy]));
                }
            }
        }

        for (int i = 0; i < X; i++) {
            System.out.println();
            for (int j = 0; j < Y; j++) {
                System.out.print(dest[i][j] + " ");
            }
        }

        System.out.println();
        System.out.println(dest[X - 1][Y - 1]);

    }

    static class Node {
        private int x;
        private int y;
        private long weight;

        public Node(int x, int y, long weight) {
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

        public long getWeight() {
            return weight;
        }
    }

}
