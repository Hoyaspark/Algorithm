package boj400;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_1463 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        queue.add(new Node(n, 0));
        visited[n] = true;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int index = poll.getIndex();
            int weight = poll.getWeight();

            if (index == 1) {
                System.out.println(weight);
                return;
            }

            if (!visited[index/3] && index % 3 == 0) {
                queue.add(new Node(index / 3, weight + 1));
                visited[index/3] = true;
            }
            if (!visited[index/2] &&index % 2 == 0) {
                queue.add(new Node(index / 2, weight + 1));
                visited[index/2] = true;
            }

            if (!visited[index - 1]) {
                queue.add(new Node(index - 1, weight + 1));
                visited[index - 1] = true;
            }

        }

    }

    static class Node {
        private int index;
        private int weight;

        public Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }

        public int getIndex() {
            return index;
        }

        public int getWeight() {
            return weight;
        }
    }

}
