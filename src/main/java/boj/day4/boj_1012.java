package boj.day4;

import java.util.*;

class Location {
    private int x;
    private int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class boj_1012 {
    static int[][] matrix;
    static boolean[][] visited;
    static int[] locX = new int[]{0, 1, 0, -1};
    static int[] locY = new int[]{-1, 0, 1, 0};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> result = new ArrayList<>();
        int testCount = scanner.nextInt();

        for (int i = 0; i < testCount; i++) {
            matrix = new int[50][50];
            visited = new boolean[50][50];

            int M = scanner.nextInt();
            int N = scanner.nextInt();
            // int[N][M]
            int K = scanner.nextInt();

            for (int j = 0; j < K; j++) {
                int num1 = scanner.nextInt();
                int num2 = scanner.nextInt();
                // 0 0 , 1 0
                matrix[num2][num1] = 1;
            }

            result.add(getLocation(M, N));
        }

        result.forEach(item -> System.out.println(item));

    }

    public static int getLocation(int M, int N) {
        // int[N][M]
        int result = 0;
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                if (matrix[n][m] == 1 && visited[n][m] == false) {
                    bfs(new Location(n, m));
                    result++;
                }
            }
        }
        return result;
    }

    public static int bfs(Location location) {
        Queue<Location> queue = new LinkedList<>();
        int result = 0;

        queue.add(location);
        visited[location.getX()][location.getY()] = true;

        while (!queue.isEmpty()) {
            Location loc = queue.poll();
            int x = loc.getX();
            int y = loc.getY();

            for (int i = 0; i < 4; i++) {
                int xx = locX[i] + x;
                int yy = locY[i] + y;

                if (xx < 0 || yy < 0 || xx > 49 || yy > 49) {
                    continue;
                }

                if (matrix[xx][yy] == 1 && visited[xx][yy] == false) {
                    queue.add(new Location(xx, yy));
                    visited[xx][yy] = true;
                    result++;
                }
            }
        }

        return result;
    }
}
