package boj.boj500;

import java.util.ArrayList;
import java.util.Scanner;

public class boj_1107 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        ArrayList<Character> list = new ArrayList<>();

        for (int i = 0; i < line.length(); i++) {
            list.add(line.charAt(i));
        }

        int n = scanner.nextInt();
        ArrayList<Character> broken = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            broken.add(String.valueOf(scanner.nextInt()).charAt(0));
        }

        int result = Math.abs(Integer.valueOf(line) - 100);

        for (int i = 0; i <= 1_000_000; i++) {
            boolean check = false;
            String a = String.valueOf(i);
            int len = a.length();

            for (int j = 0; j < len; j++) {
                if (broken.contains(a.charAt(j))) {
                    check = true;
                }
            }

            if (!check) {
                result = Math.min(result, Math.abs(Integer.valueOf(line) - i) + a.length());
            }
        }

        System.out.println(result);
    }
}
