package boj.boj520;

import java.util.ArrayList;
import java.util.Scanner;

public class boj_10972 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = scanner.nextInt();
        }


        int idx = -1;
        for (int i = n - 1; i > -1; i--) {
            if (i - 1 > -1) {
                if (list[i - 1] < list[i]) {
                    idx = i;
                    break;
                }
            }
        }

        if (idx == -1) {
            System.out.println(-1);
            return;
        }

        int idx2 = -1;
        for (int i = n - 1; i > idx - 1; i--) {
            if (list[idx - 1] < list[i]) {
                idx2 = i;
                break;
            }
        }

        int temp = list[idx - 1];
        list[idx - 1] = list[idx2];
        list[idx2] = temp;

        ArrayList<Integer> tt = new ArrayList<>();

        for (int i = idx; i < n; i++) {
            tt.add(list[i]);
        }

        tt.sort((a, b) -> a - b);

        for (int i = 0, j = idx; j < n; j++, i++) {
            list[j] = tt.get(i);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();

    }

}
