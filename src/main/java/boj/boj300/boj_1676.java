package boj.boj300;

import java.util.Scanner;

public class boj_1676 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

//        int count = 0;
//        while (n > 0) {
//            count += n / 5;
//            n /= 5;
//        }
//
//        System.out.println(count);


        int count = 0;
        for (int i = n; i >= 1; i--) {
            int num = i;
            while (num != 0) {
                count += num / 5;
                num /= 5;
            }
        }

        System.out.println(count);

    }

}
