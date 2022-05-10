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

        int num = 0;

        for (int i = 1,j=0; i <= n; i++) {
            if (i <= list.get(j)) {
                stack.push(i);
                System.out.println("+");
            }

            while (list.get(j) <= i) {
                Integer pop = stack.pop();
                System.out.println("-");
                j++;
            }
        }
    }

}
