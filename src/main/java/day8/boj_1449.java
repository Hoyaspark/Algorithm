package day8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_1449 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int L = scanner.nextInt();

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(scanner.nextInt());
        }

        list.sort((a, b) -> a - b);

        double cover = 0;
        int used = 0;
        for (int i = 0; i < list.size(); i++) {
            if ((double) list.get(i) > cover) {
                used += 1;
                cover = list.get(i) +(L - 0.5);
            }
        }

        System.out.println(used);
    }

}
