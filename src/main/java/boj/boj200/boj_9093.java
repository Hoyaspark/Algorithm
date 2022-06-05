package boj.boj200;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class boj_9093 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();

            String[] s1 = s.split(" ");

            String collect = Arrays.stream(s1).map(StringBuilder::new).map(StringBuilder::reverse)
                .collect(Collectors.joining(" "));

            System.out.println(collect);
        }
    }

}
