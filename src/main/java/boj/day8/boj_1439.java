package boj.day8;

import java.util.Scanner;

public class boj_1439 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        if (!str.contains("0") || !str.contains("1")) {
            System.out.println(0);
            return;
        }

        int oneCount = 0;
        int zeroCount = 0;

        char prev = str.charAt(0);

        if (prev == '0') {
            zeroCount++;
        } else {
            oneCount++;
        }

        for (int i = 1; i < str.length(); i++) {
            if (prev != str.charAt(i)) {
                prev = str.charAt(i);
                if (prev == '0') {
                    zeroCount++;
                } else {
                    oneCount++;
                }
            }
        }

        System.out.println(Math.min(zeroCount, oneCount));
    }

}
