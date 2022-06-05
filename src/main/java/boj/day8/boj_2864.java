package boj.day8;

import java.util.Scanner;

public class boj_2864 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        String min = str.replace("6", "5");

        String[] s = min.split(" ");

        String max = str.replace("5", "6");

        String[] s1 = max.split(" ");

        System.out.println(
            (Integer.parseInt(s[0]) + Integer.parseInt(s[1])) + " " + (Integer.parseInt(s1[0])
                + Integer.parseInt(s1[1])));
    }

}
