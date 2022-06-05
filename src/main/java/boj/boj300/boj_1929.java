package boj.boj300;

import java.util.Arrays;
import java.util.Scanner;

public class boj_1929 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        boolean[] init = new boolean[b + 1];
        Arrays.fill(init, true);
        init[1] = false;

        for (int i = 2; i <= b; i++) {
            if (i >= a) {
                if (init[i]) {
                    System.out.println(i);
                }
            }
            for (int j = 2; i * j <= b; j++) {
                init[i * j] = false;
            }
        }


    }

}
