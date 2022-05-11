package boj200;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class boj_1874 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        Stack<Integer> stack = new Stack<>();

        ArrayList<String> result = new ArrayList<>();

        int i = 1, j = 0;


        // 1 2 5 3 4
        while (j < n) {

            if (!stack.isEmpty() && stack.peek() > list.get(j)) {
                System.out.println("NO");
                return;
            }

            if (!stack.isEmpty() && stack.peek().equals(list.get(j))) {
                stack.pop();
                result.add("-");
                j++;
                continue;
            }

            stack.push(i);
            result.add("+");
            i++;

        }

        for (int k = 0; k < result.size(); k++) {
            System.out.println(result.get(k));
        }

    }

}
