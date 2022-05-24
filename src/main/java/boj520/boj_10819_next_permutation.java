package boj520;

import java.util.Arrays;
import java.util.Scanner;

public class boj_10819_next_permutation {

    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] list = new int[n];

        for (int i = 0; i < n; i++) {
            list[i] = scanner.nextInt();
        }
        Arrays.sort(list);
        cal(list);

        for (int k = 1; k < factorial(n); k++) {
            int idx = -1;

            for (int i = n - 1; i > 0; i--) {
                if (list[i] > list[i - 1]) {
                    idx = i;
                    break;
                }
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

            for (int i = idx, j = 1; i < idx + (n - idx + 1) / 2; i++, j++) {
                // swap i n-1
                int t = list[i];
                list[i] = list[n - j];
                list[n - j] = t;
            }

            cal(list);
        }

        System.out.println(max);

    }

    static int factorial(int i) {
        if (i == 1) {
            return 1;
        }
        return i * factorial(i - 1);
    }

    static void cal(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            sum += Math.abs(arr[i] - arr[i + 1]);
        }

        max = Math.max(max, sum);
    }
}
