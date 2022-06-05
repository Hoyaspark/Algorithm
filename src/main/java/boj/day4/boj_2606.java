package boj.day4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_2606 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int P = scanner.nextInt();

        int[][] nodes = new int[N+1][N+1];
        boolean[] visited = new boolean[N+1];

        for (int i = 0; i < P; i++) {
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();

            nodes[num1][num2] = nodes[num2][num1] = 1;
        }

        System.out.println(bfs(nodes, visited, N));

    }

    private static int bfs(int[][] nodes, boolean[] visited, int N) {
        Queue<Integer> queue = new LinkedList<>();

        int result = 0;

        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            Integer node = queue.poll();

            for (int i = 1; i <= N; i++) {
                if (nodes[node][i] == 1 && visited[i] == false) {
                    queue.add(i);
                    visited[i] = true;
                    result++;
                }
            }
        }


        return result;
    }

}
