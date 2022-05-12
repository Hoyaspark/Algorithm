package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_16948 {

    static int[] x = new int[]{-2, -2, 0, 0, 2, 2};
    static int[] y = new int[]{-1, 1, -2, 2, -1, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int r1 = scanner.nextInt();
        int c1 = scanner.nextInt();
        int r2 = scanner.nextInt();
        int c2 = scanner.nextInt();

        boolean[][] visited = new boolean[N][N];
        int[][] dest = new int[N][N];

        Queue<Location> queue = new LinkedList<Location>();
        dest[r1][c1] = 0;
        visited[r1][c1] = true;

        queue.add(new Location(r1, c1));

        while (!queue.isEmpty()) {
            Location poll = queue.poll();
            int r = poll.getR();
            int c = poll.getC();


            for (int i = 0; i < 6; i++) {
                int rr = x[i] + r;
                int cc = y[i] + c;

                if (rr < 0 || cc < 0 || rr > N - 1 || cc > N - 1) {
                    continue;
                }

                if (!visited[rr][cc]) {
                    dest[rr][cc] = dest[r][c] + 1;
                    visited[rr][cc] = true;
                    queue.add(new Location(rr, cc));
                }
            }
        }

        if (dest[r2][c2] == 0) {
            System.out.println("-1");
        } else {
            System.out.println(dest[r2][c2]);
        }
    }

    static class Location {

        private int r;
        private int c;

        public Location(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public int getR() {
            return r;
        }

        public int getC() {
            return c;
        }
    }

}
