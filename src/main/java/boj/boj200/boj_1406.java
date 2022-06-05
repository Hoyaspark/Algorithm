package boj.boj200;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_1406 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stack = new Stack<>();
        Stack<Character> temp = new Stack<>();

        char[] chars = br.readLine().toCharArray();

        for (int i = 0; i < chars.length; i++) {
            stack.push(chars[i]);
        }

        int N = Integer.parseInt(br.readLine());

        for (int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            char c = st.nextToken().charAt(0);

            switch (c) {
                case 'L': {
                    if (!stack.isEmpty()) {
                        temp.push(stack.pop());
                    }
                    break;
                }
                case 'B': {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;
                }
                case 'D': {
                    if (!temp.isEmpty()) {
                        stack.push(temp.pop());
                    }
                    break;
                }
                case 'P': {
                    stack.push(st.nextToken().charAt(0));
                    break;
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
