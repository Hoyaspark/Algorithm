package boj300;

import java.util.Scanner;

public class boj_10872 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        if (n == 0) {
            System.out.println(1);
            return;
        }
        for (int i = n - 1; i >= 1; i--) {
            n *= i;
        }

        System.out.println(n);
    }
}
