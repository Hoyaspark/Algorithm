package day7;

import java.util.ArrayList;
import java.util.Scanner;

public class boj_1026 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            a.add(scanner.nextInt());
        }
        for (int i = 0; i < N; i++) {
            b.add(scanner.nextInt());
        }

        a.sort((d, e) -> d - e);
        b.sort((d, e) -> e - d);

        int sum = 0;

        for (int i = 0; i < N; i++) {
            sum += a.get(i) * b.get(i);
        }

        System.out.println(sum);

    }

}
