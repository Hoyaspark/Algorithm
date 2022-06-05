package boj.day6;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class boj_1916 {

    static ArrayList<ArrayList<Mat>> matrix = new ArrayList<>();
    static int[] dest;
    static final int INF = 999_999_999;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        dest = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            matrix.add(new ArrayList<>());
            dest[i] = INF;
        }

        for (int i = 0; i < M; i++) {
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();
            int weight = scanner.nextInt();
            matrix.get(num1).add(new Mat(num2, weight));
        }

        int K = scanner.nextInt(); // 출발 도시
        int A = scanner.nextInt(); // 도착 도시

        start(K);

        System.out.println(dest[A]);
    }

    public static void start(int K) {
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> a.getWeight() - b.getWeight());

        queue.add(new Node(K, 0));
        dest[K] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int index = node.getIndex(); // K -> index 도시
            int weight = node.getWeight(); // K -> index 까지의 비용

            if (weight > dest[index]) {
                continue;
            }

            for (int i = 0; i < matrix.get(index).size(); i++) {
                Mat mat = matrix.get(index).get(i);
                int y = mat.getY(); // index -> y
                int w = mat.getWeight(); // index -> y 까지의 비용 w

                if (dest[y] > dest[index] + w) {
                    dest[y] = dest[index] + w;
                    queue.add(new Node(y, dest[y]));
                }
            }
        }
    }

    static class Mat {
        private int y;
        private int weight;

        public Mat(int y, int weight) {
            this.y = y;
            this.weight = weight;
        }

        public int getY() {
            return y;
        }

        public int getWeight() {
            return weight;
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
