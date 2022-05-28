package review;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class review_12904_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        Queue<String> queue = new LinkedList<String>();

        queue.add(b);

        while (!queue.isEmpty()) {
            String poll = queue.poll();
            if (poll.length() < a.length()) {
                System.out.println(0);
                return;
            }
            if (poll.equals(a)) {
                System.out.println(1);
                return;
            }

            StringBuilder str = new StringBuilder(poll);
            if (poll.charAt(poll.length() - 1) == 'A') {

                queue.add(str.substring(0, poll.length() - 1).toString());
            } else if (poll.charAt(poll.length() - 1) == 'B') {
                queue.add(str.reverse().substring(1, poll.length()).toString());
            }
        }

    }
}
