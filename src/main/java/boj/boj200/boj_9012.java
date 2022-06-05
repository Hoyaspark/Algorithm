package boj.boj200;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class boj_9012 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(scanner.nextLine());
        }

        for (int i = 0; i < n; i++) {
            Stack<Character> stack = new Stack<>();
            boolean game = false;
            String s = list.get(i);
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);

                if (c == '(') {
                    stack.push(c);
                } else {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        game = true;
                        break;
                    }
                }
            }

            if (game || !stack.isEmpty()) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }

}
