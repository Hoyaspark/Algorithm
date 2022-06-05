package boj.day3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HideAndSeek {

    static int[] matrix;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int source = scanner.nextInt();
        int dest = scanner.nextInt();

        visited = new boolean[100_001];
        matrix = new int[100_001];

        for (int i = 1; i <= 100_000; i++) {
            visited[i] = false;
        }

        System.out.println(bfs(source, dest));

    }

    public static int bfs(int start, int dest) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            Integer node = queue.poll();

            if (visited[dest]) {
                return matrix[dest];
            }

            // x-1
            if (node - 1 >= 0 && visited[node - 1] == false) {

                matrix[node - 1] = matrix[node] + 1;
                queue.add(node - 1);
                visited[node - 1] = true;
            }

            // x+1
            if (node + 1 <= 100_000 && visited[node + 1] == false) {

                matrix[node + 1] = matrix[node] + 1;
                queue.add(node + 1);
                visited[node + 1] = true;
            }

            // x*2
            if (node * 2 <= 100_000 && visited[node * 2] == false) {

                matrix[node * 2] = matrix[node] + 1;

                queue.add(node * 2);
                visited[node * 2] = true;
            }
        }
        return -1;
    }
}
