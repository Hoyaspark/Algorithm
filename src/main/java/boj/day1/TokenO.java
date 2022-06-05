package boj.day1;

import java.util.Scanner;

public class TokenO {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        int current = scanner.nextInt();
        int result = 0;
        int token[] = new int[size];

        for (int i = 0; i < size; i++) {
            token[i] = scanner.nextInt();
        }

        for (int i = size - 1; i > -1; i--) {
            if (current / token[i] != 0) {
                result += current / token[i];
                current -= (current / token[i]) * token[i];
            }
        }

        System.out.println(result);

    }
}
