package boj.day2;

import java.util.*;

class HouseLocation {
    int x;
    int y;

    public HouseLocation(int x, int y) {
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

class HouseBfs {

    int[] targetX = new int[]{0, 1, 0, -1};
    int[] targetY = new int[]{1, 0, -1, 0};


    public void bfs(int[][] matrix, boolean[][] visited, HouseLocation houseLocation, int l, int[][] dist, Map<Integer, Integer> result) {
        Queue<HouseLocation> queue = new LinkedList<>();

        queue.add(houseLocation);
        visited[houseLocation.getX()][houseLocation.getY()] = true;
        dist[houseLocation.getX()][houseLocation.getY()] = l;
        result.put(l, result.get(l) + 1);

        while (!queue.isEmpty()) {
            HouseLocation location = queue.poll();
            int x = location.getX();
            int y = location.getY();

            for (int i = 0; i < 4; i++) {
                int xx = x + targetX[i];
                int yy = y + targetY[i];

                if (xx < 1 || yy < 1 || xx > matrix.length - 1 || yy > matrix.length - 1) {
                    continue;
                }

                if (matrix[xx][yy] == 1 && visited[xx][yy] == false) {
                    queue.add(new HouseLocation(xx, yy));
                    visited[xx][yy] = true;
                    dist[xx][yy] = l;
                    result.put(l, result.get(l) + 1);
                }
            }
        }
    }
}

public class PasteHouse {

    static int[][] matrix;
    static boolean[][] visited;
    static Queue<Integer> line;
    static int[][] dist;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        matrix = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];
        Map<Integer, Integer> result = new HashMap<Integer, Integer>();

        scanner.nextLine();

        for (int i = 1; i <= N; i++) {
            String s = scanner.nextLine();
            for (int j = 1; j <= N; j++) {
                matrix[i][j] = s.charAt(j - 1) - '0';
            }
        }

        HouseBfs houseBfs = new HouseBfs();
        line = new LinkedList<>();
        dist = new int[matrix.length][matrix.length];

        int l = 1;
        int x = 0, y = 0;
        boolean xy = false;
        boolean set = false;
        while (true) {

            for (int i = 1; i <= N; i++) {
                if (xy) {
                    break;
                }
                for (int j = 1; j <= N; j++) {
                    if (matrix[i][j] == 1 && dist[i][j] == 0) {
                        x = i;
                        y = j;
                        l++;
                        xy = true;
                        break;
                    }

                    if (i == N && j == N) {
                        set = true;
                    }

                }

            }

            if (set) {
                System.out.println(line.size());
                List<Integer> test = new ArrayList<>();
                while (!line.isEmpty()) {
                    test.add(result.get(line.poll()));
                }
                test.sort((a,b) -> {
                    return a-b;
                });

                for (Integer integer : test) {
                    System.out.println(integer);
                }
                return;
            }
            line.add(l);
            result.put(l, 0);
            houseBfs.bfs(matrix, visited, new HouseLocation(x, y), l, dist, result);
            xy = false;

        }


    }
}
