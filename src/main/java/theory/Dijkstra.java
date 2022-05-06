package theory;

import java.util.Arrays;
import java.util.PriorityQueue;

class Node {
    private int num;
    private int weight;

    public int getNum() {
        return num;
    }

    public int getWeight() {
        return weight;
    }

    public Node(int num, int weight) {
        this.num = num;
        this.weight = weight;
    }

}

public class Dijkstra {
    static int[][] matrix;
    static int[] dest;
    static final int INF = 100000;

    public static void main(String[] args) {
        matrix = new int[][]{
            {0, 7, 9, INF, INF, 14},
            {7, 0, 10, 15, INF ,INF},
            {9, 10, 0, 11, INF, 2},
            {INF, 15, 11, 0, 6, INF},
            {INF, INF, INF, 6, 0, 9},
            {14, INF, 2, INF, 9, 0}
        };
        dest = new int[6];
        for (int i = 0; i < dest.length; i++) {
            dest[i] = INF;
        }

        start(new Node(0, 0));

    }

    public static void start(Node startNode) {
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> a.getWeight() - b.getWeight());

        queue.add(startNode);
        dest[0] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int index = node.getNum(); // 선택된 노드 번호
            int weight = node.getWeight(); // 0에서부터 선택된 노드 번호까지의 거리

            if (weight > dest[index]) {
                continue;
            }

            for (int i = 0; i < matrix.length; i++) {
                if (matrix[index][i] != 0 && dest[i] > dest[index] + matrix[index][i]) {
                    dest[i] = dest[index] + matrix[index][i];
                    queue.add(new Node(i, dest[i]));
                }
            }
        }

        Arrays.stream(dest).forEach(num -> System.out.print(num + " "));

    }

}
