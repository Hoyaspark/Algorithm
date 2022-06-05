package boj.boj300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_1978 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        int count = 0;
        boolean[] check = new boolean[1001];
        Arrays.fill(check, true);
        check[1] = false;

        for (int i = 2; i <= 1000; i++) {
            for (int j = 2; j <= 1000; j++) {
                if (i * j <= 1000) {
                    check[i * j] = false;
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if (check[list.get(i)]) {
                count++;
            }
        }

        System.out.println(count);

    }

}
