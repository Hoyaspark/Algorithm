package boj.day5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class boj_1753 {
    static ArrayList<ArrayList<Mat>> matrix = new ArrayList<>();
    static int[] dest;
    static final int INF = 1000000;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int V = scanner.nextInt();
        int E = scanner.nextInt();
        int K = scanner.nextInt();

        dest = new int[V + 1];

        for (int i = 0; i < V + 1; i++) {
            matrix.add(new ArrayList<>());
            dest[i] = INF;
        }

        for (int i = 0; i < E; i++) {
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();
            int weight = scanner.nextInt();

            matrix.get(num1).add(new Mat(num2, weight));
        }

        start(K);

        for (int i = 1; i < V + 1; i++) {
            if (dest[i] == INF) {
                System.out.println("INF");
                continue;
            }

            System.out.println(dest[i]);
        }


    }

    public static void start(int K) {
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> a.getWeight() - b.getWeight());

        queue.add(new Node(K, 0));
        dest[K] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int index = node.getIndex();// 해당 정점
            int weight = node.getWeight();// 해당 정점까지의 거리

            if (weight > dest[index]) {
                continue;
            }

            ArrayList<Mat> mats = matrix.get(index);
            mats.sort((a, b) -> b.getWeight() - a.getWeight());

            Map<Integer, Mat> map = new HashMap<>();
            for (Mat mat : mats){
                map.put(mat.getY(), mat);
            }

            for (Mat value : map.values()) {
                int y = value.getY(); // index -> y
                int w = value.getWeight(); // index -> y = w

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
