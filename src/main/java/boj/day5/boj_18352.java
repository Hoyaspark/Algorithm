package boj.day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class boj_18352 {
    static int[] dest;
    static ArrayList<ArrayList<Mat>> matrix = new ArrayList<>();
    static final int INF = 10000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String a = scanner.nextLine();
        String[] s = a.split(" ");
        int N = Integer.valueOf(s[0]); // 정점의 갯수
        int M = Integer.valueOf(s[1]); // 간선의 갯수
        int K = Integer.valueOf(s[2]); // 정확한 거리
        int X = Integer.valueOf(s[3]); // 출발 도시 번호

        dest = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            matrix.add(new ArrayList<>());
            dest[i] = INF;
        }

        for (int i = 0; i < M; i++) {
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();
            matrix.get(num1).add(new Mat(num2, 1));
        }


        start(X);

        boolean b = Arrays.stream(dest)
            .boxed()
            .anyMatch(num -> num.equals(K));

        if (!b) {
            System.out.println("-1");
            return;
        }

        for (int i = 1; i < dest.length; i++) {
            if (dest[i] == K) {
                System.out.println(i);
            }
        }
    }

    public static void start(int X) {
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> a.getWeight() - b.getWeight());

        queue.add(new Node(X, 0));
        dest[X] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int index = node.getIndex();
            int weight = node.getWeight(); // 출발점 X 부터 index 까지의 거리

            if (weight > dest[index]) {
                continue;
            }

            for (int i = 0; i < matrix.get(index).size(); i++) {
                Mat mat = matrix.get(index).get(i);// matrix[1] -> 2 -> 4 --> (1,2) (1,4)
                int y = mat.getY();// matrix[index][y]
                int w = mat.getWeight(); // matrix[index][y] = w
                if (dest[y] > dest[index] + w) {
                    dest[y] = dest[index] + w;
                    queue.add(new Node(y, dest[y]));
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
