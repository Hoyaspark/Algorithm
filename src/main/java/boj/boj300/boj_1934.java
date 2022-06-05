package boj.boj300;

import java.util.ArrayList;
import java.util.Scanner;

public class boj_1934 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        ArrayList<Node> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            list.add(new Node(Math.max(x, y), Math.min(x, y)));
        }

        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            // 최대 공약수 찾기
            int a = node.x, b = node.y, x = 0;
            while (true) {
                if (a % b == 0) {
                    x = b;
                    break;
                }
                x = a % b;
                a = b;
                b = x;
            }

            // x / y * 최대공약수로 최대공배수 찾기
            System.out.println((node.x * node.y) / x);
        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
