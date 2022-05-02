package day2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Location {
    int x;
    int y;

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

class Maze {

    public int[] targetX = new int[]{0, 1, 0, -1};
    public int[] targetY = new int[]{1, 0, -1, 0};

    public int[][] dist;


    public int[][] bfs(int[][] matrix, boolean[][] visited, Location lc) {
        Queue<Location> queue = new LinkedList<>();

        dist = new int[matrix.length][matrix[0].length];

        queue.add(lc);
        visited[1][1] = true;
        dist[1][1] = 1;

        while (!queue.isEmpty()) {
            Location location = queue.poll();
            int x = location.getX();
            int y = location.getY();

            for (int i = 0; i < 4; i++) {
                int xx = this.targetX[i];
                int yy = this.targetY[i];

                if (x + xx < 1 || y + yy < 1 || x + xx > matrix.length - 1 || y + yy > matrix[0].length - 1) {
                    continue;
                }

                if (matrix[x + xx][y + yy] == 1 && visited[x + xx][y + yy] == false) {
                    queue.add(new Location(x + xx, y + yy));
                    visited[x + xx][y + yy] = true;
                    dist[x + xx][y + yy] = dist[x][y] + 1;
                }
            }

        }
        return dist;
    }

}

public class MazeQuest {
    static int[][] matrix;
    static boolean[][] visited;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        scanner.nextLine();

        matrix = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();

            for (int j = 1; j <= m; j++) {
                matrix[i][j] = input.charAt(j - 1) - '0';
            }
        }


        Maze maze = new Maze();
        int[][] dist = maze.bfs(matrix, visited, new Location(1, 1));

        System.out.println(dist[n][m]);

    }
}
