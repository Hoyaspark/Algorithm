package boj.boj520;

import java.util.ArrayList;
import java.util.Scanner;

public class boj_10973 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        int idx = -1;
        for (int i = n - 1; i > 0; i--) {
            if (array[i] < array[i - 1]) {
                idx = i;
                break;
            }
        }

        if (idx == -1) {
            System.out.println(-1);
            return;
        }

        int idx2 = -1;
        for (int i = n - 1; i > idx - 1; i--) {
            if (array[idx - 1] > array[i]) {
                idx2 = i;
                break;
            }
        }

        // swap array[idx-1], array[idx2]

        int temp = array[idx - 1];
        array[idx - 1] = array[idx2];
        array[idx2] = temp;

        ArrayList<Integer> tt = new ArrayList<>();

        for (int i = idx; i < n; i++) {
            tt.add(array[i]);
        }

        tt.sort((a, b) -> b - a);

        for (int i = 0, j = idx; j < n; j++, i++) {
            array[j] = tt.get(i);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
