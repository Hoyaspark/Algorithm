package day7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_16953 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long A = scanner.nextInt();
        long B = scanner.nextInt();

        start(A, B);
    }

    private static void start(long A, long B) {
        Queue<Mul> queue = new LinkedList<>();

        queue.add(new Mul(A ,0));

        while (!queue.isEmpty()) {
            Mul poll = queue.poll();

            if (poll.getNum() == B) {
                System.out.println(poll.getCount() + 1);
                return;
            }

            if (poll.getNum() > B) {
                continue;
            }

            queue.add(new Mul(poll.getNum() * 2, poll.getCount() + 1));
            queue.add(new Mul((poll.getNum() * 10) + 1, poll.getCount() + 1));
        }

        System.out.println(-1);
        return;
    }

    static class Mul {
        private long num;
        private int count;

        public Mul(long num, int count) {
            this.num = num;
            this.count = count;
        }

        public long getNum() {
            return num;
        }

        public int getCount() {
            return count;
        }
    }

}
