package boj.review;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class review_12904 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();

        String t = scanner.nextLine();

        Queue<String> queue = new LinkedList<String>();

        queue.add(t);

        while (!queue.isEmpty()) {
            new StringBuilder();
            String poll = queue.poll();

            if (poll.length() < s.length()) {
                System.out.println(0);
                return;
            }

            if (poll.equals(s)) {
                System.out.println(1);
                return;
            }

            if (poll.charAt(poll.length() - 1) == 'A') {
                queue.add(new StringBuilder(poll).deleteCharAt(poll.length() - 1).toString());
            } else if (poll.charAt(poll.length() - 1) == 'B') {
                queue.add(
                        new StringBuilder(poll).deleteCharAt(poll.length() - 1).reverse().toString());
            }
        }
    }
}
