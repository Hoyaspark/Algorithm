package day7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_12904 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String S = scanner.nextLine();
        String T = scanner.nextLine();

        Queue<String> queue = new LinkedList<>();
        queue.add(T);

        while (!queue.isEmpty()) {
            String poll = queue.poll();

            if (poll.length() == S.length()) {
                if (poll.equals(S)) {
                    System.out.println(1);
                    return;
                }
                continue;
            }

            if (poll.charAt(poll.length() - 1) == 'A') {
                queue.add(new StringBuilder(poll).deleteCharAt(poll.length() - 1).toString());
            } else if (poll.charAt(poll.length() - 1) == 'B') {
                queue.add(
                    new StringBuilder(poll).deleteCharAt(poll.length() - 1).reverse().toString());
            }
        }

        System.out.println(0);

        return;
    }

}
