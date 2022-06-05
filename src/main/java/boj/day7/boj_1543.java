package boj.day7;

import java.util.Scanner;

public class boj_1543 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        String pattern = scanner.nextLine();

        int result = 0;
        StringBuilder stringBuilder = new StringBuilder(str);
        while (true) {
            int pos = stringBuilder.indexOf(pattern);

            if (pos == -1) {
                break;
            }
            result++;

            stringBuilder.delete(0, pos + pattern.length());

        }

        System.out.println(result);

    }

}
