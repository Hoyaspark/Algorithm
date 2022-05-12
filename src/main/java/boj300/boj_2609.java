package boj300;

import java.util.Scanner;

public class boj_2609 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int c = Math.max(a, b), d = Math.min(a, b), x = 0;

        while (true) {
            if (c % d == 0) {
                x = d;
                System.out.println(x);
                break;
            }

            x = d;
            d = c % d;
            c = x;
        }

        System.out.println((a * b) / x);

    }

}
