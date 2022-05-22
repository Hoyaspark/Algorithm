package boj500;

import java.util.ArrayList;
import java.util.Scanner;

public class boj_1476 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] split = scanner.nextLine().split(" ");

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            list.add(Integer.parseInt(split[i]));
        }

        int count = 1;
        int e = 1;
        int s = 1;
        int m = 1;
        while (true) {
            if (e == list.get(0) && s == list.get(1) && m == list.get(2)) {
                System.out.println(count);
                return;
            }
            if (e++ + 1 > 15) {
                e = 1;
            }
            if (s++ + 1 > 28) {
                s = 1;
            }
            if (m++ + 1 > 19) {
                m = 1;
            }

            count++;
        }
    }
}
