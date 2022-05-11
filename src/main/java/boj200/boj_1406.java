package boj200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_1406 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Queue<String> cmdList = new LinkedList<>();

        Stack<Character> stack = new Stack<>();
        Stack<Character> temp = new Stack<>();

        char[] chars = scanner.nextLine().toCharArray();

        for (int i = 0; i < chars.length; i++) {
            stack.push(chars[i]);
        }

        int N = scanner.nextInt();

        scanner.nextLine();

        for (int i = 0; i < N; i++) {
            cmdList.add(scanner.nextLine());
        }

        while(!cmdList.isEmpty()){
            String cmd = cmdList.poll();
            if (cmd.length() > 1) {
                // P x
                char[] aa = cmd.toCharArray();
                stack.push(aa[2]);
            } else {
                // L B D
                switch (cmd){
                    case "L" : {
                        if (!stack.isEmpty()) {
                            temp.push(stack.pop());
                        }
                        break;
                    }
                    case "B" : {
                        if (!stack.isEmpty()) {
                            stack.pop();
                        }
                        break;
                    }
                    case "D" : {
                        if (!temp.isEmpty()) {
                            stack.push(temp.pop());
                        }
                        break;
                    }
                }

            }
        }

        while (!stack.isEmpty()) {
            temp.push(stack.pop());
        }

        StringBuilder result = new StringBuilder();

        while (!temp.isEmpty()) {
            result.append(temp.pop());
        }

        System.out.println(result);



    }

}
