package boj.day6;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.function.Predicate;

public class boj_1504 {

    static ArrayList<ArrayList<Mat>> matrix = new ArrayList<>();
    static final int INF = 200000 * 1000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int E = scanner.nextInt();

        for (int i = 0; i <= N; i++) {
            matrix.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int weight = scanner.nextInt();
            matrix.get(x).add(new Mat(y, weight));
            matrix.get(y).add(new Mat(x, weight));
        }

        int mustX = scanner.nextInt(); // 1 ~ mustX 까지의 최소 경로 , 1 ~ mustY 까지의 최소 경로
        int mustY = scanner.nextInt(); // mustY ~ N 까지의 최소 경로 , mustX ~ N 까지의 최소 경로

        int resultA = start(1, mustX, N) + start(mustX, mustY, N) + start(mustY, N, N);
        int resultB = start(1, mustY, N) + start(mustY, mustX, N) + start(mustX, N, N);

        if (resultA >= INF && resultB >= INF) {
            System.out.println("-1");
            return;
        }
        System.out.println(Math.min(resultA, resultB));

    }

    private static int start(int start, int end, int N) {
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> a.getWeight() - b.getWeight());
        int[] dest = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            dest[i] = INF;
        }

        queue.add(new Node(start, 0));
        dest[start] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int index = node.getIndex();
            int weight = node.getWeight();

            if (weight > dest[index]) {
                continue;
            }

            for (int i = 0; i < matrix.get(index).size(); i++) {
                Mat mat = matrix.get(index).get(i);
                int y = mat.getY(); // index -> y 까지
                int w = mat.getWeight(); // index -> y 까지의 가중치

                if (dest[y] > dest[index] + w) {
                    dest[y] = dest[index] + w;
                    queue.add(new Node(y, dest[y]));
                }
            }
        }

        return dest[end];
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

}
