package day4;

import java.util.*;

class Locations {
    private int x;
    private int y;

    public Locations(int x, int y) {
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

public class boj_7576 {
    static int[][] matrix;
    static int[] expectX = new int[]{-1, 0, 1, 0};
    static int[] expectY = new int[]{0, 1, 0, -1};
    static int N = 0;
    static int M = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String a = scanner.nextLine();
        String[] s = a.split(" ");

        M = Integer.parseInt(s[0]);
        N = Integer.parseInt(s[1]);

        matrix = new int[N][M];

        boolean init = false;
        List<Locations> input = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String s1 = scanner.nextLine();
            String[] s2 = s1.split(" ");
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(s2[j]);
                if (num == 0) {
                    init = true;
                }
                if (num == 1) {
                    input.add(new Locations(i, j));
                }
                matrix[i][j] = num;
            }
        }

        // 만약 0이 없다면 -1 출력
        if (!init) {
            System.out.println("0");
            return;
        }

        // queue에 1인 곳을 다 넣는다.
        int result = bfs(input);


        System.out.println(result);

    }

    public static int bfs(List<Locations> locations) {
        int result = 0;
        Queue<Locations> queue = new LinkedList<>();

        queue.addAll(locations);

        while (!queue.isEmpty()) {
            Locations loc = queue.poll();
            int x = loc.getX();
            int y = loc.getY();

            for (int i = 0; i < 4; i++) {
                int xx = x + expectX[i];
                int yy = y + expectY[i];

                if (xx >= 0 && xx < N && yy >= 0 && yy < M) {
                    if (matrix[xx][yy] == 0) {
                        queue.add(new Locations(xx, yy));
                        matrix[xx][yy] = matrix[x][y] + 1;
                    }
                }

            }

            if (queue.isEmpty()) {
                result = matrix[x][y];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == 0) {
                    return -1;
                }
            }
        }

        return result - 1;
    }

}
