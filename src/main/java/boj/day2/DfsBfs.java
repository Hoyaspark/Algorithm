package boj.day2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Dfs {

    private int nodes;
    private int[][] dfs;
    private boolean[] visited;

    public Dfs(int nodes) {
        this.nodes = nodes;

        this.dfs = new int[nodes + 1][nodes + 1];
        this.visited = new boolean[nodes + 1];
    }

    public void put(int x, int y) {
        this.dfs[x][y] = this.dfs[y][x] = 1; //연결 되어있다 의미
    }

    public void start(int startNode) {
        this.visited[startNode] = true;

        System.out.print(startNode + " ");

        for (int i = 1; i <= nodes; i++) {
            if (dfs[startNode][i] == 1 && visited[i] == false) {
                start(i);
            }
        }
    }
}


class Bfs {
    private int nodes;
    private int[][] bfs;
    private boolean[] visited;
    private Queue<Integer> queue;

    public Bfs(int nodes) {
        this.nodes = nodes;
        this.queue = new LinkedList<>();
        this.bfs = new int[nodes + 1][nodes + 1];
        this.visited = new boolean[nodes + 1];
    }

    public void put(int x,int y) {
        this.bfs[x][y] = this.bfs[y][x] = 1;
    }

    public void start(int startNode) {
        queue.add(startNode);
        visited[startNode] = true;

        while (!queue.isEmpty()) {
            Integer v = queue.poll();
            System.out.print(v + " ");

            for (int i = 1; i <= nodes; i++) {
                if (bfs[v][i] == 1 && visited[i] == false) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}

public class DfsBfs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nodes = scanner.nextInt();
        int vertex = scanner.nextInt();
        int startNode = scanner.nextInt();

        Dfs dfs = new Dfs(nodes);
        Bfs bfs = new Bfs(nodes);

        for (int i = 0; i < vertex; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            dfs.put(x, y);
            bfs.put(x, y);
        }

        dfs.start(startNode);
        System.out.println();
        bfs.start(startNode);
    }

}
