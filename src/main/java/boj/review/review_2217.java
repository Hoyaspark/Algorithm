package boj.review;

import java.util.ArrayList;
import java.util.Scanner;

public class review_2217 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(scanner.nextInt());
        }

        list.sort((a, b) -> a - b);

        for (int i = 0; i < N; i++) {
            result.add(list.get(i) * (N - i));
        }

        result.sort((a, b) -> b - a);

        System.out.println(result.get(0));

    }

}
