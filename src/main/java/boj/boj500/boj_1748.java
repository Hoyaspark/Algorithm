package boj.boj500;

import java.util.Scanner;

public class boj_1748 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();

        int sum = 0, divide = 100_000_000;
        while (true) {
            if (divide == 0) {
                break;
            }
            if (a / divide != 0) {
                sum += (a - divide + 1) * String.valueOf(divide).length();
                a = divide - 1;
            }
            divide /= 10;
        }

        System.out.println(sum);
    }
}
