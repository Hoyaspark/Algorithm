package boj201;

import java.util.Scanner;
import java.util.Stack;

public class boj_17413 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char[] chars = scanner.nextLine().toCharArray();

        Stack<Character> stack = new Stack<Character>();
        Stack<Character> flag = new Stack<Character>();
        Stack<Character> str = new Stack<Character>();

        for (int i = 0; i < chars.length; i++) {
            stack.push(chars[i]);
        }

        while (!stack.isEmpty()) {
            if (stack.peek().equals('>')) {
                while (!str.isEmpty()) {
                    flag.push(str.pop());
                }
                flag.push(stack.pop());
                while (!stack.peek().equals('<')) {
                    flag.push(stack.pop());
                }
                flag.push(stack.pop());
            } else if (stack.peek().equals(' ')){
                str.push(stack.pop());
            }
        }

        while (!flag.isEmpty()) {
            System.out.print(flag.pop());
        }
    }

}
