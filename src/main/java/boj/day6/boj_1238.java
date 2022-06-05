package boj.day6;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class boj_1238 {

    static ArrayList<ArrayList<Mat>> matrix = new ArrayList<>();
    static int[] startDest;
    static int[] backDest;
    static final int INF = 999_999_999;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int partyCity = scanner.nextInt(); // 파티 도시

        startDest = new int[N + 1];
        backDest = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            matrix.add(new ArrayList<>());
            backDest[i] = INF;
        }

        for (int i = 0; i < M; i++) {
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();
            int weight = scanner.nextInt();
            matrix.get(num1).add(new Mat(num2, weight));
        }

        // 각각의 도시에서 파티 도시로
        start(N, partyCity);

        // 파티 도시에서 각가의 도시로
        arrive(partyCity);

        // sum
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (startDest[i] == INF || backDest[i] == INF) {
                continue;
            }
            result.add(startDest[i] + backDest[i]);
        }

        result.sort((a, b) -> b - a);

        // 최소 추출 -> 해당 인덱스 추출
        System.out.println(result.get(0));
    }

    public static void start(int n, int partyCity) {

        for (int i = 1; i <= n; i++) {

            int[] dest = new int[n + 1];

            for (int j = 0; j <= n; j++) {
                dest[j] = INF;
            }

            PriorityQueue<Node> queue = new PriorityQueue<>(
                (a, b) -> a.getWeight() - b.getWeight());

            queue.add(new Node(i, 0));
            dest[i] = 0;

            while (!queue.isEmpty()) {
                Node node = queue.poll();
                int index = node.getIndex(); // i -> index
                int weight = node.getWeight(); // i -> index = weight

                if (weight > dest[index]) {
                    continue;
                }

                for (int k = 0; k < matrix.get(index).size(); k++) {
                    Mat mat = matrix.get(index).get(k);
                    int y = mat.getY(); // index -> y
                    int w = mat.getWeight(); // index -> y = w

                    if (dest[y] > dest[index] + w) {
                        dest[y] = dest[index] + w;
                        queue.add(new Node(y, dest[y]));
                    }
                }
            }
            startDest[i] = dest[partyCity];

        }
    }

    public static void arrive(int partyCity) {
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> a.getWeight() - b.getWeight());

        queue.add(new Node(partyCity, 0));
        backDest[partyCity] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int index = node.getIndex(); // partyCity -> index
            int weight = node.getWeight(); // partyCity -> index = weight

            if (weight > backDest[index]) {
                continue;
            }

            for (int i = 0; i < matrix.get(index).size(); i++) {
                Mat mat = matrix.get(index).get(i);
                int y = mat.getY();// index -> y
                int w = mat.getWeight();// index -> y = w

                if (backDest[y] > backDest[index] + w) {
                    backDest[y] = backDest[index] + w;
                    queue.add(new Node(y, backDest[y]));
                }
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
